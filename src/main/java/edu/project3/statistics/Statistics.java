package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.util.ArrayList;
import java.util.List;

public abstract class Statistics {
    protected final List<Pair> table;

    public Statistics() {
        table = new ArrayList<>();
    }

    public abstract void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list);

    public abstract String getTitle();

    public String getTable() {
        int len1 = table.stream()
            .map(x -> x.first().length())
            .max(Integer::compareTo)
            .get();

        int len2 = table.stream()
            .map(x -> x.second().length())
            .max(Integer::compareTo)
            .get();

        StringBuilder sb = new StringBuilder();
        Pair head = table.get(0);

        sb.append("\n")
            .append(head.first())
            .append(" ".repeat(len1 - head.first().length()))
            .append("|")
            .append(head.second())
            .append("\n");

        sb.append("-".repeat(len1 - 1))
            .append(":|:")
            .append("-".repeat(len2 - 1))
            .append("\n");

        for (var i = 1; i < table.size(); i++) {
            sb.append(table.get(i).first())
                .append(" ".repeat(len1 - table.get(i).first().length()))
                .append("|")
                .append(table.get(i).second())
                .append("\n");
        }

        return sb.toString();
    }
}
