package com.example.ledger.model;

import java.util.Date;

public class Ledger {
    public static final String ACCOUNT_ID = "AccountID";
    public static final String VOUCHER_ID = "VoucherID";
    public static final String DATE = "Date";
    public static final String ENTRY = "Entry";
    public static final String DR = "DR";
    public static final String CR = "CR";
    public static final String AMOUNT = "Amount";
    public static final String BALANCE = "Balance";
    public static final String BALANCE1 = "Balance1";
    public static final String MOBILE = "Mobile";

    private int accountId;
    private int voucherId;
    private Date date;
    private String entry;
    private double dr;
    private double cr;
    private double amount;
    private String balance;
    private String balance1;
    private long mobile;

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setBalance1(String balance1) {
        this.balance1 = balance1;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public double getDr() {
        return dr;
    }

    public void setDr(double dr) {
        this.dr = dr;
    }

    public double getCr() {
        return cr;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}
