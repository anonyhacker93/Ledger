package com.example.ledger.model;

import java.util.Date;
import java.util.List;

public class Account {
    public static final String ACCOUNT = "Account";
    public static final String ACCOUNT_NAME = "AccountName";
    public static final String DATE_OF_BIRTH = "DateOfBirth";
    public static final String MOBILE = "Mobile";
    public static final String EMAIL = "Email";
    public static final String BALANCE = "Balance";
    public static final String CITY = "City";
    public static final String ACCOUNT_ID = "AcountID";
    public static final String BALANCE_1 = "Balance1";
    public static final String LEDGER = "Ledger";

    private String accountName;
    private Date dob;
    private long mobile;
    private String email;
    private String balance;
    private String city;
    private int accountId;
    private String balance1;
    private List<Ledger> ledgerList;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getBalance1() {
        return balance1;
    }

    public void setBalance1(String balance1) {
        this.balance1 = balance1;
    }

    public List<Ledger> getLedgerList() {
        return ledgerList;
    }

    public void setLedgerList(List<Ledger> ledgerList) {
        this.ledgerList = ledgerList;
    }
}
