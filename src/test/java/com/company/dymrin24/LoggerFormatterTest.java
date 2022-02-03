package com.company.dymrin24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

public class LoggerFormatterTest {


    @ParameterizedTest
    @NullSource
    public void testThrowNullPointerException_whenTheMessageInfoIsNull_inTheMessage(String message) {
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new LoggerFormatter("[{date}][{level}] Message: {msg}").format(new Date(), LoggingLevel.INFO, message);
            }
        });
    }

    @ParameterizedTest
    @NullSource
    public void testThrowNullPointerException_whenTheLoggingLevelIsNull_inTheMessage(LoggingLevel level) {
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new LoggerFormatter("[{date}][{level}] Message: {msg}").format(new Date(), level, "something");
            }
        });
    }

    @ParameterizedTest
    @NullSource
    public void testThrowNullPointerException_whenTheDateIsNull_inTheMessage(Date date) {
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new LoggerFormatter("[{date}][{level}] Message: {msg}").format(date, LoggingLevel.INFO, "something");
            }
        });
    }

    @ParameterizedTest
    @MethodSource("formatsWithDifferentParameters")
    public void testShowTheMessageFromDifferentFormats_inTheMessage(String expected, String format) {
        Assertions.assertEquals(expected, new LoggerFormatter(format).format(new Date(2022, Calendar.DECEMBER, 20), LoggingLevel.INFO, "Hola"));
    }

    private static Stream<Arguments> formatsWithDifferentParameters() {
        return Stream.of(
                Arguments.of("[Wed Dec 20 00:00:00 EET 3922][INFO] Message: Hola", "[{date}][{level}] Message: {msg}"),
                Arguments.of("[INFO] Message: Hola", "[{level}] Message: {msg}"),
                Arguments.of("[Wed Dec 20 00:00:00 EET 3922] Message: Hola", "[{date}] Message: {msg}"),
                Arguments.of("[Wed Dec 20 00:00:00 EET 3922][INFO] Message: ", "[{date}][{level}] Message: ")
        );
    }
}
