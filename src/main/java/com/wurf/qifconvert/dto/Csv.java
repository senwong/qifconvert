package com.wurf.qifconvert.dto;

import java.util.LinkedList;
import java.util.List;

public class Csv<T extends CsvEntry> {

    private String accountName;

    private String header;

    private List<T> transactions = new LinkedList<T>();

    public List<T> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<T> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(T transaction) {
        if(header == null) {
            header = transaction.getHeader();
        }
        transactions.add(transaction);
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(header);
        for (T transaction : transactions) {
            s.append(transaction.toString()).append('\n');
        }
        return s.toString();
    }
}
