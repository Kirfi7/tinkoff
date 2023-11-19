package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.time.LocalDate;
import java.util.List;

public class GeneralInfo extends Statistics {
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        table.add(new Pair("Метрика", "Значение"));
        table.add(new Pair("Файл", terminalRequest.uri().getPath()));
        LocalDate from = terminalRequest.filterFrom();
        LocalDate to = terminalRequest.filterTo();

        table.add(new Pair("Начальная дата", from != null ? String.valueOf(from) : "-"));
        table.add(new Pair("Конечная дата", to != null ? String.valueOf(to) : "-"));
        table.add(new Pair("Количество запросов", String.valueOf(list.size())));

        String averageAnswerSize;
        if (list.isEmpty()) {
            averageAnswerSize = "0b";
        } else {
            averageAnswerSize = list.stream()
                .map(Request::bytesSent)
                .reduce(0L, Long::sum, Long::sum) / list.size() + "b";
        }

        table.add(new Pair("Средний размер ответа", averageAnswerSize));
    }

    @Override
    public String getTitle() {
        return "Общая информация";
    }
}
