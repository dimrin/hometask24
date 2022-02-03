package com.company.dymrin24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.nio.file.Path;

public class FileLoggerValidatorTest {

    @Test
    public void testThrowFileMaxSizeReachedException_whenTheLengthOfMessageIsBiggerThanMaxFileSize() {
        Assertions.assertThrows(FileMaxSizeReachedException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FileLoggerValidator(new FileLoggerConfiguration(Path.of(".", "logging.out"),
                        com.company.dymrin24.LoggingLevel.INFO,
                        100000,
                        "[{date}][{level}] Message: {msg}")).checkPermittedFileSize(100001);
            }
        });
    }

}
