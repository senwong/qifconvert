package com.wurf.qifconvert.dto.qif;

import java.util.ArrayList;
import java.util.List;

public class AccountDto {

    private String name;

    private List<TransactionDto> transactions = new ArrayList<TransactionDto>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(TransactionDto transaction) {
        this.transactions.add(transaction);
    }
}
