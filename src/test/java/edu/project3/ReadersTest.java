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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadersTest {
    private final static int INDEX_LINE_WITH_PATH = 6;

    private static Stream<Arguments> argumentProvider() {
        var constant = new Constant(1);

        return Stream.of(
            Arguments.of(
                "java -jar nginx-log-stats.jar --path src/main/java/edu/project3/logs.txt --format adoc",
                "java -jar nginx-log-stats.jar --path https://raw.githubusercontent.com/elastic/"
                    + "examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --format adoc"
            ),
            Arguments.of(
                "java -jar nginx-log-stats.jar --path src/main/java/edu/project3/logs.txt",
                "java -jar nginx-log-stats.jar --path https://raw.githubusercontent.com/elastic/"
                    + "examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs"
            ),
            Arguments.of(
                "java -jar nginx-log-stats.jar --path src/main/java/edu/project3/logs.txt --format markdown",
                "java -jar nginx-log-stats.jar --path https://raw.githubusercontent.com/elastic/"
                    + "examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --format markdown"
            ),
            Arguments.of(
                "java -jar nginx-log-stats.jar --path src/main/java/edu/project3/logs.txt --from 2015-05-30 --format markdown",
                "java -jar nginx-log-stats.jar --path https://raw.githubusercontent.com/elastic/"
                    +
                    "examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --from 2015-05-30 --format markdown"
            ),
            Arguments.of(
                "java -jar nginx-log-stats.jar --path src/main/java/edu/project3/logs.txt --from 2025-05-30 --format markdown",
                "java -jar nginx-log-stats.jar --path https://raw.githubusercontent.com/elastic/"
                    +
                    "examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --from 2025-05-30 --format markdown"
            ),
            Arguments.of(
                "java -jar nginx-log-stats.jar --path src/main/java/edu/project3/logs.txt --from 2015-05-30 --to 2015-06-10 --format markdown",
                "java -jar nginx-log-stats.jar --path https://raw.githubusercontent.com/elastic/"
                    +
                    "examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --from 2015-05-30 --to 2015-06-10 --format markdown"
            ),
            Arguments.of(
                "java -jar nginx-log-stats.jar --path src/main/java/edu/project3/logs.txt --to 2015-06-10 --format markdown",
                "java -jar nginx-log-stats.jar --path https://raw.githubusercontent.com/elastic/"
                    + "examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --to 2015-06-10 --format markdown"
            ),
            Arguments.of(
                "java -jar nginx-log-stats.jar --path src/main/java/edu/project3/logs.txt --to 2010-06-10 --format markdown",
                "java -jar nginx-log-stats.jar --path https://raw.githubusercontent.com/elastic/"
                    + "examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --to 2010-06-10 --format markdown"
            )
        );
    }

    private ReadersTest() {
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void test(String commandToFile, String commandToHttp) {
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

        List<Statistics> needStatistics1 = new ArrayList<>() {{
            add(new GeneralInfo());
            add(new ResourcesCountInfo());
            add(new StatusCodesCountInfo());
            add(new ClientMemoryInfo());
            add(new RequestMethodCountInfo());
            add(new PopularHourInfo());
            add(new UserAgentCountInfo());
            add(new ClientRequestCountInfo());
        }};

        LoggerAnalyzer httpAnalyzer = getAnalyzer(needStatistics, commandToHttp);
        LoggerAnalyzer fileAnalyzer = getAnalyzer(needStatistics1, commandToFile);

        String fileStatistics = removeLineWithPath(fileAnalyzer.getAnalysis());
        String httpStatistics = removeLineWithPath(httpAnalyzer.getAnalysis());

        assertThat(fileStatistics)
            .isEqualTo(httpStatistics);
    }

    private LoggerAnalyzer getAnalyzer(List<Statistics> needStatistics, String command) {
        TerminalRequest request;
        try (InputStream in = new ByteArrayInputStream(command.getBytes())) {
            Terminal.setInputStream(in);
            request = Terminal.expectRequest();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new LoggerAnalyzer(request, needStatistics);
    }

    private String removeLineWithPath(String result) {
        StringBuilder sb = new StringBuilder();
        String[] lines = result.split("\n");

        for (int i = INDEX_LINE_WITH_PATH + 1; i < lines.length; i++) {
            sb.append(lines[i])
                .append("\n");
        }

        return sb.toString();
    }
}

