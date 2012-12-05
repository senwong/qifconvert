package com.wurf.qifconvert.builder;

enum TransactionType {
    DATE("D"), PAYEE("P"), MEMO("M"), AMOUNT("T"), STATUS("C"), CATEGORY("L"), NUMBER("N"), HEADER("!");
    private String value;

    TransactionType(String value) {
        this.value = value;
    }

    static TransactionType fromValue(String value) {
        TransactionType[] values = TransactionType.values();
        for (TransactionType type : values) {
            if(type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("unknown value " + value);
    }
}
