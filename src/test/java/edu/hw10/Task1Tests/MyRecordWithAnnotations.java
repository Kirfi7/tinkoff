package edu.hw10.Task1Tests;

import edu.hw10.Task1.Max;
import edu.hw10.Task1.Min;
import edu.hw10.Task1.NotNull;

public record MyRecordWithAnnotations(
    @Min(0) int real,
    @Max(0) double doubl,
    @Min(0) @Max(10) int real2,
    @NotNull String str
) {
}
