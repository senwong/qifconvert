package com.wurf.qifconvert.builder;

import com.wurf.qifconvert.dto.qif.AccountDto;
import com.wurf.qifconvert.dto.qif.QifDto;
import com.wurf.qifconvert.dto.qif.TransactionDto;
import com.wurf.qifconvert.util.ResourceParseUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.List;

public class QifBuilder {

    private static final String DELIMITER_ACCOUNT = "!Account";
    private static final String DELIMITER_TRANSACTION = "^";

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public static QifDto getQifDto(List<String> lines) {
        QifDto qifDto = new QifDto();

        List<List<String>> allAccountLines = ResourceParseUtil.parseLines(lines, DELIMITER_ACCOUNT);
        for (List<String> accountLines : allAccountLines) {
            AccountDto accountDto = new AccountDto();
            List<List<String>> transactions = ResourceParseUtil.parseLines(accountLines, DELIMITER_TRANSACTION);
            for (List<String> transaction : transactions) {
                if (isHeader(transaction)) {
                    accountDto.setName(getName(transaction));
                } else {
                    accountDto.addTransaction(buildTransactionDto(transaction));
                }
            }
            qifDto.addAccount(accountDto);
        }

        return qifDto;
    }

    public static TransactionDto buildTransactionDto(final List<String> lines) {
        TransactionDto result = new TransactionDto();
        for (String line : lines) {
            QifLine qifLine = new QifLine(line);
            switch (qifLine.getType()) {
                case DATE:
                    try {
                        result.setDate(DateUtils.parseDate(qifLine.getValue(), DATE_FORMAT));
                    } catch (ParseException e) {
                        throw new RuntimeException("unable to parse date: " + qifLine.getValue(), e);
                    }
                    break;
                case MEMO:
                    result.setMemo(qifLine.getValue());
                    break;
                case PAYEE:
                    result.setPayee(qifLine.getValue());
                    break;
                case AMOUNT:
                    result.setAmount(qifLine.getValue().replace('.', ','));
                    break;
                case CATEGORY:
                    result.setCategory(qifLine.getValue());
                    break;
                case NUMBER:
                    result.setNumber(qifLine.getValue());
                    break;
                case STATUS:
                case HEADER:
                    break;
                default:
                    throw new RuntimeException("unknown type " + qifLine.getType());
            }
        }
        return result;
    }

    private static String getName(List<String> transaction) {
        for (String line : transaction) {
            if(line.startsWith("N")) {
                return line.substring(1, line.length());
            }
        }
        throw new RuntimeException("no name found!");
    }

    private static boolean isHeader(List<String> transaction) {
        return transaction.size() == 1 && transaction.get(0).startsWith("N");
    }
}
