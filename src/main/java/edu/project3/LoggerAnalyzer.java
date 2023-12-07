package edu.project3;

import edu.project3.readers.FileReader;
import edu.project3.readers.ReaderHTTP;
import edu.project3.readers.ReaderURI;
import edu.project3.statistics.Statistics;
import edu.project3.terminal.TerminalRequest;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoggerAnalyzer {
    private final FutureTask<String> task;
    private final Thread thread;

    public LoggerAnalyzer(TerminalRequest request, List<Statistics> statisticsTypes) {
        Pattern httpPattern = Pattern.compile("^http");
        Matcher matcher = httpPattern.matcher(request.uri().toString());

        ReaderURI reader = matcher.find() ? new ReaderHTTP() : new FileReader();
        String titleType = request.resultFormat() == TerminalRequest.ResultFormat.ADOC ? "====" : "####";

        task = new FutureTask<>(
            () -> {
                String logs = reader.read(request.uri());
                List<Request> parsedLogs = LoggerParser.parse(logs);
                List<Request> filteredLogs = new Filter(parsedLogs)
                    .betweenDates(request.filterFrom(), request.filterTo())
                    .toList();

                StringBuilder sb = new StringBuilder();

                for (Statistics i : statisticsTypes) {
                    i.setAndCalculateData(request, filteredLogs);

                    sb.append("\n\n")
                        .append(titleType)
                        .append(" ")
                        .append(i.getTitle())
                        .append("\n")
                        .append(i.getTable());
                }

                return sb.toString();
            }
        );
        thread = new Thread(task);
        thread.start();
    }

    public String getAnalysis() {
        try {
            return task.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
