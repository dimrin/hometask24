package com.company.dymrin24;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

public class FileLoggerWriter {
    private final FileLoggerConfiguration configuration;
    private final LoggerFormatter formatter;

    public FileLoggerWriter(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        formatter = new LoggerFormatter(configuration.getFormat());
    }

    public void write(String message) {
        write(configuration.getToWrite(), message);
    }


    private void write(Path file, String message) {
        write(file.toFile(), message);
    }


    private void write(File file, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(formatter.format(new Date(), LoggingLevel.DEBUG, message));
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("SWW while the file read-operation.", e);
        }
    }
}
