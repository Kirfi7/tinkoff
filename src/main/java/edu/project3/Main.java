package edu.project3;

import edu.project3.statistics.ClientMemoryInfo;
import edu.project3.statistics.ClientRequestCountInfo;
import edu.project3.statistics.GeneralInfo;
import edu.project3.statistics.PopularHourInfo;
import edu.project3.statistics.RequestMethodCountInfo;
import edu.project3.statistics.ResourcesCountInfo;
import edu.project3.statistics.Statistics;
import edu.project3.statistics.StatusCodesCountInfo;
import edu.project3.statistics.UserAgentCountInfo;
import edu.project3.terminal.Terminal;
import edu.project3.terminal.TerminalRequest;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        List<Statistics> needStatistics = new ArrayList<>() {{
            add(new GeneralInfo());
            add(new ResourcesCountInfo());
            add(new StatusCodesCountInfo());
            add(new ClientMemoryInfo());
            add(new RequestMethodCountInfo());
            add(new PopularHourInfo());
            add(new UserAgentCountInfo());
            add(new ClientRequestCountInfo());
        }};

        TerminalRequest request = Terminal.expectRequest();
        LoggerAnalyzer analyzer = new LoggerAnalyzer(request, needStatistics);
        Terminal.getLogger().info(analyzer.getAnalysis());
    }
}
