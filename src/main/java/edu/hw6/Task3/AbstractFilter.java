package edu.hw6.Task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    static AbstractFilter regularFile() {
        return Files::isRegularFile;
    }

    static AbstractFilter readable() {
        return Files::isReadable;
    }

    static AbstractFilter writable() {
        return Files::isWritable;
    }

    static AbstractFilter largerThan(long size) {
        return entry -> Files.size(entry) >= size;
    }

    static AbstractFilter smallerThan(long size) {
        return entry -> Files.size(entry) <= size;
    }

    static AbstractFilter hasExtension(String extension) {
        return entry -> entry.getFileName().toString().endsWith("." + extension);
    }

    static AbstractFilter nameMatchesRegex(String regex) {
        return entry -> entry.getFileName().toString().matches(regex);
    }

    static AbstractFilter magicNumber(Object... bytes) {
        return entry -> {
            if (Files.isDirectory(entry)) {
                return false;
            }

            byte[] entryBytes = Files.readAllBytes(entry);
            if (entryBytes.length < bytes.length) {
                return false;
            }

            for (int i = 0; i < bytes.length; i++) {
                if (entryBytes[i] != (int) bytes[i]) {
                    return false;
                }
            }
            return true;
        };
    }

    static AbstractFilter globMatches(String glob) {
        return entry -> entry.getFileName().toString().endsWith(glob);
    }

    static AbstractFilter regexContains(String regex) {
        return entry -> Pattern.compile(regex).matcher(entry.toString()).find();
    }

    default AbstractFilter and(AbstractFilter other) {
        return x -> this.accept(x) && other.accept(x);
    }

    default AbstractFilter or(AbstractFilter other) {
        return x -> this.accept(x) || other.accept(x);
    }
}
