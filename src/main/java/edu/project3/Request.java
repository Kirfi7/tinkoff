package edu.project3;

import java.net.URI;
import java.time.LocalDateTime;

public record Request(
    String ip,
    String user,
    LocalDateTime dateTime,
    MethodRequest methodRequest,
    URI uri,
    String protocol,
    int status,
    long bytesSent,
    String httpReferer,
    String userAgent
) {
    public enum MethodRequest {
        GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS, CONNECT, TRACE
    }
}
