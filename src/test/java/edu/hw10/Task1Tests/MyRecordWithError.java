package edu.hw10.Task1Tests;

import edu.hw10.Task1.NotNull;
import java.util.List;

public record MyRecordWithError(@NotNull List<Integer> list) {
}
