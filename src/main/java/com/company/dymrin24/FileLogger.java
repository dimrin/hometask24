package com.company.dymrin24;

public class FileLogger {

    private final FileLoggerConfiguration configuration;
    private final FileLoggerWriter loggerWriter;
    private final FileLoggerValidator loggerValidator;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        loggerWriter = new FileLoggerWriter(configuration);
        this.loggerValidator = new FileLoggerValidator(configuration);
    }

    public void info(String message) {

        loggerValidator.checkPermittedFileSize(message.length());
        loggerWriter.write(message);
    }

    public void debug(String message) {


        loggerValidator.checkPermittedFileSize(message.length());
        loggerWriter.write(message);
    }
}
