package edu.hw11.Task3;

import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;

public class Task3 extends ClassLoader {
    private final static String CLASS_NAME = "GeneratedClass";
    private final static String METHOD_NAME = "fib";
    private final static String METHOD_DESCRIPTOR = "(I)J";

    public static long generateFibAndGet(int n) {
        byte[] classBytes = generateClass();
        Class<?> clazz = new Task3()
            .defineClass(CLASS_NAME, classBytes, 0, classBytes.length);

        try {
            return (long) clazz.getMethod(METHOD_NAME, int.class).invoke(null, n);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static byte[] generateClass() {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, CLASS_NAME,
            null, "java/lang/Object", null);

        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC,
            METHOD_NAME, METHOD_DESCRIPTOR, null, null);

        changeMV(mv);
        cw.visitEnd();

        return cw.toByteArray();
    }

    private static void changeMV(MethodVisitor mv) {
        mv.visitCode();

        Label invokeRecurs = new Label();

        //if n <= 1
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitInsn(Opcodes.ICONST_1);
        mv.visitJumpInsn(Opcodes.IF_ICMPGT, invokeRecurs);

        // return n
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitInsn(Opcodes.I2L);
        mv.visitInsn(Opcodes.LRETURN);

        //else
        mv.visitLabel(invokeRecurs);

        // fib (n - 1)
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitInsn(Opcodes.ICONST_1);
        mv.visitInsn(Opcodes.ISUB);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, CLASS_NAME, METHOD_NAME, METHOD_DESCRIPTOR, false);

        // fib (n - 2)
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitInsn(Opcodes.ICONST_2);
        mv.visitInsn(Opcodes.ISUB);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, CLASS_NAME, METHOD_NAME, METHOD_DESCRIPTOR, false);

        // return fib + fib
        mv.visitInsn(Opcodes.LADD);
        mv.visitInsn(Opcodes.LRETURN);

        mv.visitMaxs(2, 2);
        mv.visitEnd();
    }
}
