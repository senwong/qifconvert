package com.wurf.qifconvert.dto.hibiscus1;

import com.wurf.qifconvert.dto.CsvEntry;

/**
 * Nummer;Buchungsdatum;Valutadatum;Waehrung;Betrag;Empfaengername;Bankleitzahl;Kontonummer;Referenz;Textschluessel;
 * Kommentar;Kategorie;Verwendungszweck_1;Verwendungszweck_2;Verwendungszweck_3;Verwendungszweck_4;Verwendungszweck_5;
 * Verwendungszweck_6;Verwendungszweck_7;Verwendungszweck_8;Verwendungszweck_9;Verwendungszweck_10;Verwendungszweck_11;
 * Verwendungszweck_12;Verwendungszweck_13;Verwendungszweck_14

 */
public class Hibiscus1 extends CsvEntry {

    public static final String HEADER = "Nummer;Buchungsdatum;Valutadatum;Waehrung;Betrag;Empfaengername;" +
            "Bankleitzahl;Kontonummer;Referenz;Textschluessel;Kommentar;Kategorie;Verwendungszweck_1;" +
            "Verwendungszweck_2;Verwendungszweck_3;Verwendungszweck_4;Verwendungszweck_5;Verwendungszweck_6;" +
            "Verwendungszweck_7;Verwendungszweck_8;Verwendungszweck_9;Verwendungszweck_10;Verwendungszweck_11;" +
            "Verwendungszweck_12;Verwendungszweck_13;Verwendungszweck_14\n";

    private String number;
    private String bookingDate;
    private String valutaDate;
    private String currency;
    private String amount;
    private String payee;
    private String blz;
    private String accountNumber;
    private String referenz;
    private String textKey;
    private String comment;
    private String category;
    private String usage1;
    private String usage2;
    private String usage3;
    private String usage4;
    private String usage5;
    private String usage6;
    private String usage7;
    private String usage8;
    private String usage9;
    private String usage10;
    private String usage11;
    private String usage12;
    private String usage13;
    private String usage14;

    public String getHeader() {
        return HEADER;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getValutaDate() {
        return valutaDate;
    }

    public void setValutaDate(String valutaDate) {
        this.valutaDate = valutaDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getBlz() {
        return blz;
    }

    public void setBlz(String blz) {
        this.blz = blz;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getReferenz() {
        return referenz;
    }

    public void setReferenz(String referenz) {
        this.referenz = referenz;
    }

    public String getTextKey() {
        return textKey;
    }

    public void setTextKey(String textKey) {
        this.textKey = textKey;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsage1() {
        return usage1;
    }

    public void setUsage1(String usage1) {
        this.usage1 = usage1;
    }

    public String getUsage2() {
        return usage2;
    }

    public void setUsage2(String usage2) {
        this.usage2 = usage2;
    }

    public String getUsage3() {
        return usage3;
    }

    public void setUsage3(String usage3) {
        this.usage3 = usage3;
    }

    public String getUsage4() {
        return usage4;
    }

    public void setUsage4(String usage4) {
        this.usage4 = usage4;
    }

    public String getUsage5() {
        return usage5;
    }

    public void setUsage5(String usage5) {
        this.usage5 = usage5;
    }

    public String getUsage6() {
        return usage6;
    }

    public void setUsage6(String usage6) {
        this.usage6 = usage6;
    }

    public String getUsage7() {
        return usage7;
    }

    public void setUsage7(String usage7) {
        this.usage7 = usage7;
    }

    public String getUsage8() {
        return usage8;
    }

    public void setUsage8(String usage8) {
        this.usage8 = usage8;
    }

    public String getUsage9() {
        return usage9;
    }

    public void setUsage9(String usage9) {
        this.usage9 = usage9;
    }

    public String getUsage10() {
        return usage10;
    }

    public void setUsage10(String usage10) {
        this.usage10 = usage10;
    }

    public String getUsage11() {
        return usage11;
    }

    public void setUsage11(String usage11) {
        this.usage11 = usage11;
    }

    public String getUsage12() {
        return usage12;
    }

    public void setUsage12(String usage12) {
        this.usage12 = usage12;
    }

    public String getUsage13() {
        return usage13;
    }

    public void setUsage13(String usage13) {
        this.usage13 = usage13;
    }

    public String getUsage14() {
        return usage14;
    }

    public void setUsage14(String usage14) {
        this.usage14 = usage14;
    }

}
