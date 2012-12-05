package com.wurf.qifconvert.dto.qif;

import java.util.LinkedList;
import java.util.List;

public class QifDto {

    private List<AccountDto> accounts = new LinkedList<AccountDto>();

    public List<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(AccountDto account) {
        accounts.add(account);
    }
}
