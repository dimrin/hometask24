package com.company.dymrin24;

import java.io.File;

public final class FileLoggerValidator {

    private final FileLoggerConfiguration loggerConfiguration;

    public FileLoggerValidator(FileLoggerConfiguration loggerConfiguration) {
        this.loggerConfiguration = loggerConfiguration;
    }

    public void checkPermittedFileSize(long messageSize) {
        File file = loggerConfiguration.getToWrite().toFile();
        long tempLength = file.length() + messageSize;

        if (tempLength > loggerConfiguration.getMaxSize()) {
            throw new FileMaxSizeReachedException(
                    String.format("File [%s] reached size [%s] that is higher than max available [%s]",
                            loggerConfiguration.getToWrite(),
                            messageSize,
                            loggerConfiguration.getMaxSize()
                    )
            );
        }
    }
}
