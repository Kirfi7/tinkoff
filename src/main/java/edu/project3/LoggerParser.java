package edu.project3;

import edu.project3.terminal.Terminal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoggerParser {
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss");
    private static final Pattern IP_PATTERN = Pattern.compile("(\\d+\\.){3}\\d");
    private static final Pattern IPV6_PATTERN = Pattern.compile("((^|:)([0-9a-fA-F]{0,4})){1,8}");
    private static final Pattern USER_PATTERN = Pattern.compile("\\s-\\s[^\\[]+\\[");
    private static final Pattern DATETIME_PATTERN = Pattern.compile("\\d{2}/[A-z]{3,}/\\d{4}(:\\d{2}){3}");
    private static final Pattern GROUP_DATA_PATTERN = Pattern.compile("\"[^\"]+\"");
    private static final Pattern STATUS_WITH_BYTES_PATTERN = Pattern.compile("\"\\s\\d{3}\\s\\d+\\s\"");

    private LoggerParser() {
    }

    public static List<Request> parse(String input) {
        String[] lines = input.split("\n");
        List<Request> res = new ArrayList<>(lines.length);

        for (String line : lines) {
            Matcher ipMatcher = IP_PATTERN.matcher(line);
            Matcher ipv6Matcher = IPV6_PATTERN.matcher(line);
            Matcher userMatcher = USER_PATTERN.matcher(line);
            Matcher dateTimeMatcher = DATETIME_PATTERN.matcher(line);
            Matcher groupDataMatcher = GROUP_DATA_PATTERN.matcher(line);
            Matcher statusWithBytesMatcher = STATUS_WITH_BYTES_PATTERN.matcher(line);

            boolean isIpv4 = ipMatcher.find();

            if (!isIpv4 && !findInMatcher(ipv6Matcher, line) || !findInMatcher(dateTimeMatcher, line)) {
                return List.of();
            }

            String ip = isIpv4 ? ipMatcher.group() : ipv6Matcher.group();
            String user = parseMatcher(userMatcher, line, 2 + 1, 2);
            String firstGroup = parseMatcher(groupDataMatcher, line, 1, 1);
            String httpReferer = parseMatcher(groupDataMatcher, line, 1, 1);
            String userAgent = parseMatcher(groupDataMatcher, line, 1, 1);
            String statusAndBytesStr = parseMatcher(statusWithBytesMatcher, line, 2, 2);
            LocalDateTime time = getDateTime(dateTimeMatcher.group());

            if (firstGroup == null || statusAndBytesStr == null || time == null) {
                return List.of();
            }

            String splitSpaces = "\\s+";
            String[] firstDataGroup = firstGroup.split(splitSpaces);
            Request.MethodRequest methodRequest = getMethodRequest(firstDataGroup[0]);
            URI uri = parseURI(firstDataGroup[1]);
            String protocol = firstDataGroup[2];

            if (uri == null || methodRequest == null) {
                return List.of();
            }

            String[] statusAndBytes = statusAndBytesStr.split(splitSpaces);
            int status = Integer.parseInt(statusAndBytes[0]);
            long bytes = Long.parseLong(statusAndBytes[1]);

            res.add(
                new Request(
                    ip, user, time, methodRequest, uri, protocol, status, bytes, httpReferer, userAgent
                )
            );
        }

        return res;
    }

    private static LocalDateTime getDateTime(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            Terminal.getLogger().error(String.format("Illegal datetime: %s", dateTime));
            return null;
        }
    }

    private static String parseMatcher(Matcher matcher, String line, int cutOnLeft, int cutOnRight) {
        if (!findInMatcher(matcher, line)) {
            return null;
        }

        var group = matcher.group();
        return group.substring(cutOnLeft, group.length() - cutOnRight);
    }

    private static Request.MethodRequest getMethodRequest(String methodRequest) {
        try {
            return Enum.valueOf(Request.MethodRequest.class, methodRequest);
        } catch (IllegalArgumentException e) {
            Terminal.getLogger().error(String.format("Illegal method: %s", methodRequest));
            return null;
        }
    }

    private static URI parseURI(String path) {
        try {
            return new URI(path);
        } catch (URISyntaxException e) {
            Terminal.getLogger().error(e.getMessage());
            return null;
        }
    }

    private static boolean findInMatcher(Matcher matcher, String line) {
        if (!matcher.find()) {
            Terminal.getLogger().error(String.format("Can't parse log: %s", line));
            return false;
        }

        return true;
    }
}
