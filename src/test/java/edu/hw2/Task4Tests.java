package edu.hw2;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Task4Tests {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void testCallingInfoUtil() {
        Task4.CallingInfo callingInfo = new Task4().new CallingInfoUtil().callingInfo();
        assertEquals("edu.hw2.Task4Tests", callingInfo.className());
        assertEquals("testCallingInfoUtil", callingInfo.methodName());
    }

    @Test
    public void testDifferentCallingInfo() {
        Task4.CallingInfo callingInfo = Task4.CallingInfoUtil.callingInfo();
        assertNotEquals("edu.hw2.AnotherClass", callingInfo.className());
        assertNotEquals("someOtherMethod", callingInfo.methodName());
    }
}
