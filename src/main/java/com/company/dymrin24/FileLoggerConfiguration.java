package com.company.dymrin24;

import java.nio.file.Path;

public class FileLoggerConfiguration {
    private final Path toWrite;
    private final LoggingLevel lvl;
    private final long maxSize;
    private final String format;

    public FileLoggerConfiguration(Path toWrite, LoggingLevel lvl, long maxSize, String format) {
        this.toWrite = toWrite;
        this.lvl = lvl;
        this.maxSize = maxSize;
        this.format = format;
    }

    public Path getToWrite() {
        return toWrite;
    }

    public LoggingLevel getLvl() {
        return lvl;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getFormat() {
        return format;
    }
}
