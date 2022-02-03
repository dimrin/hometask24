package com.company.dymrin24;

import java.util.Date;

public class LoggerFormatter {

    private static final String DATE_PLACEHOLDER = "{date}";
    private static final String LEVEL_PLACEHOLDER = "{level}";
    private static final String MESSAGE_PLACEHOLDER = "{msg}";

    private final String format;

    public LoggerFormatter(String format) {
        this.format = format;
    }


    public String format(Date date, LoggingLevel level, String message) {
        return format.replace(DATE_PLACEHOLDER, date.toString())
                .replace(LEVEL_PLACEHOLDER, level.toString())
                .replace(MESSAGE_PLACEHOLDER, message);
    }
}
