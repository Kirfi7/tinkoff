package edu.project3.readers;

import java.io.FileInputStream;
import java.net.URI;

public class FileReader implements ReaderURI {
    @Override
    public String read(URI uri) {
        byte[] bytes;

        try (FileInputStream reader = new FileInputStream(uri.toString())) {
            bytes = reader.readAllBytes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        StringBuilder sb = new StringBuilder();
        char character;

        for (int i = 0; i < bytes.length && bytes[i] > 0; i++) {
            character = (char) bytes[i];
            sb.append(character);
        }

        return sb.toString();
    }
}
