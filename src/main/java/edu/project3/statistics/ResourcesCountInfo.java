package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourcesCountInfo extends Statistics {
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        Map<URI, Integer> map = new HashMap<>();
        for (Request i : list) {
            map.put(i.uri(), map.getOrDefault(i.uri(), 0) + 1);
        }

        table.add(new Pair("Ресурс", "Количество"));
        for (URI i : map.keySet()) {
            table.add(new Pair(i.toString(), map.get(i).toString()));
        }
    }

    @Override
    public String getTitle() {
        return "Запрашиваемые ресурсы";
    }
}
