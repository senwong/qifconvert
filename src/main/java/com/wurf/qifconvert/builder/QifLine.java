package com.wurf.qifconvert.builder;

class QifLine {

    private TransactionType type;
    private String value;

    protected QifLine(String line) {
        type = TransactionType.fromValue(line.substring(0, 1));
        value = line.substring(1, line.length());
    }

    protected TransactionType getType() {
        return type;
    }

    protected String getValue() {
        return value;
    }
}
