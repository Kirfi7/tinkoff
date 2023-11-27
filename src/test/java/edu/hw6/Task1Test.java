package edu.hw6;

import edu.hw6.Task1.DiskMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    private Task1Test() {
    }

    @Test
    void testMapOnDisk() {
        String fileName = "test.txt";
        Map<String, String> myMap = new HashMap<>() {{
            put("abc", "yes");
            put("vvv", "no");
            put("aac", "no");
            put("vankl", "yes");
            put("tacbc", "no");
        }};

        DiskMap createdMap = new DiskMap();
        for (var i : myMap.keySet()) {
            createdMap.put(i, myMap.get(i));
        }

        createdMap.writeToFile(fileName);

        createdMap = null;
        System.gc();

        DiskMap readMap = new DiskMap(fileName);

        for (var i : myMap.keySet()) {
            assertThat(readMap.get(i)).isEqualTo(myMap.get(i));
        }

        try {
            Files.deleteIfExists(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
