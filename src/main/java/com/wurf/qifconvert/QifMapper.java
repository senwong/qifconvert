package com.wurf.qifconvert;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.google.common.collect.Lists;
import com.wurf.qifconvert.dto.Csv;
import com.wurf.qifconvert.dto.CsvEntry;
import com.wurf.qifconvert.dto.qif.AccountDto;
import com.wurf.qifconvert.dto.qif.QifDto;
import com.wurf.qifconvert.dto.qif.TransactionDto;

public final class QifMapper<T extends CsvEntry> {

    private DozerBeanMapper mapper = new DozerBeanMapper();

    public List<Csv<T>> toCsv(final QifDto qifDto, final Class clazz) {
        String mappingResource = String.format("com/wurf/qifconvert/mapping/%s.xml", clazz.getSimpleName().toLowerCase());
        mapper.setMappingFiles(Lists.newArrayList(mappingResource));
        List<Csv<T>> result = new ArrayList<>();
        List<AccountDto> accounts = qifDto.getAccounts();
        for (AccountDto account : accounts) {
            Csv<T> csv = map(account, clazz);
            csv.setAccountName(account.getName());
            result.add(csv);
        }
        return result;
    }

    private Csv<T> map(final AccountDto account, final Class<T> clazz) {
        Csv<T> result = new Csv<>();
        List<TransactionDto> transactions = account.getTransactions();
        for (TransactionDto transaction : transactions) {
            result.addTransaction(mapper.map(transaction, clazz));
        }
        return result;
    }

}
