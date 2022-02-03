package com.company.dymrin24;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfiguration configuration = new com.company.dymrin24.FileLoggerConfiguration(
                Path.of(".", "logging.out"),
                com.company.dymrin24.LoggingLevel.INFO,
                100000,
                "[{date}][{level}] Message: {msg}");

        FileLogger fileLogger = new com.company.dymrin24.FileLogger(configuration);
        fileLogger.info("Hello world !");
    }
}
