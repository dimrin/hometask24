package com.company.dymrin24;

import java.util.List;

public enum LoggingLevelAcceptance {

    INFO(List.of(LoggingLevel.INFO)),
    DEBUG(List.of(LoggingLevel.INFO, LoggingLevel.DEBUG));

    private final List<LoggingLevel> acceptedValues;

    LoggingLevelAcceptance(List<LoggingLevel> acceptedValues) {
        this.acceptedValues = acceptedValues;
    }

}
