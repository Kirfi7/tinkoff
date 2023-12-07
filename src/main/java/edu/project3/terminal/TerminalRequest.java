package edu.project3.terminal;

import java.net.URI;
import java.time.LocalDate;

public record TerminalRequest(URI uri, LocalDate filterFrom, LocalDate filterTo, ResultFormat resultFormat) {
    public enum ResultFormat {
        MARKDOWN, ADOC
    }
}
