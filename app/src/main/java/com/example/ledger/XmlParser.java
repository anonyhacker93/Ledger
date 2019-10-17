package com.example.ledger;

import android.util.Log;

import com.example.ledger.model.Account;
import com.example.ledger.model.Ledger;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XmlParser {

    private List<Account> accountList;
    private List<Ledger> ledgerList;

    private Account account;
    private Ledger ledger;
    private String text;

    public XmlParser() {
        accountList = new ArrayList<>();
        ledgerList = new ArrayList<>();
    }

    public List<Account> parse(InputStream is) throws XmlPullParserException, IOException {
        XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
        parserFactory.setNamespaceAware(true);
        XmlPullParser parser = parserFactory.newPullParser();
        parser.setInput(is, null);

        int type = parser.getEventType();

        while (type != XmlPullParser.END_DOCUMENT) {
            String tagName = parser.getName();
            Log.d("LedgerTag", "TagName:" + tagName);
            if (type == XmlPullParser.START_TAG) {
                if (tagName.equalsIgnoreCase(Account.ACCOUNT)) {
                    account = new Account();
                    ledgerList = new ArrayList<>();

                } else if (tagName.equalsIgnoreCase(Account.LEDGER)) {
                    ledger = new Ledger();
                }

            } else if (type == XmlPullParser.TEXT) {
                text = parser.getText();
                Log.d("LedgerTag", "Text:" + text);
            } else if (type == XmlPullParser.END_TAG) {
                //Acount Details
                if (tagName.equalsIgnoreCase("collection")) {
                    break;
                }
                if (tagName.equalsIgnoreCase(Account.LEDGER)) {
                    ledgerList.add(ledger);
                } else if (tagName.equalsIgnoreCase(Account.ACCOUNT)) {
                    account.setLedgerList(ledgerList);
                    accountList.add(account);
                }

                /*if (text != null) {
                    text = text.trim();
                    if (text.isEmpty()) {
                        type = parser.next();
                        continue;
                    }
                } else {
                    type = parser.next();
                    continue;
                }*/
                text = text.trim();
                if (tagName !=null && tagName.equalsIgnoreCase(Account.ACCOUNT_NAME)) {
                    if(text!=null && !text.isEmpty())
                    account.setAccountName(text);
                } else if (tagName !=null && tagName.equalsIgnoreCase(Account.DATE_OF_BIRTH)) {
                   // account.setDob(new Date(text));
                } else if (tagName !=null && tagName.equalsIgnoreCase(Account.MOBILE)) {
                    if(text!=null && !text.isEmpty())
                    account.setMobile(Long.parseLong(text));
                } else if (tagName !=null && tagName.equalsIgnoreCase(Account.EMAIL)) {
                    if(text!=null && !text.isEmpty())
                    account.setEmail(text);
                } else if (tagName !=null && tagName.equalsIgnoreCase(Account.BALANCE)) {
                    if(text!=null && !text.isEmpty())
                    account.setBalance(text);
                } else if (tagName !=null && tagName.equalsIgnoreCase(Account.CITY)) {
                    if(text!=null && !text.isEmpty())
                    account.setCity(text);
                } else if (tagName !=null && tagName.equalsIgnoreCase(Account.ACCOUNT_ID)) {
                    if(text!=null && !text.isEmpty())
                    account.setAccountId(Integer.parseInt(text));
                }
                //Ledger Details
                if (ledger != null) {
                    if (tagName.equalsIgnoreCase(Ledger.ACCOUNT_ID)) {
                        if(text!=null && !text.isEmpty())
                        ledger.setAccountId(Integer.parseInt(text));
                    } else if (tagName.equalsIgnoreCase(Ledger.VOUCHER_ID)) {
                        if(text!=null && !text.isEmpty())
                        ledger.setVoucherId(Integer.parseInt(text));
                    } else if (tagName.equalsIgnoreCase(Ledger.DATE)) {
                       // ledger.setDate(new Date(text));
                    } else if (tagName.equalsIgnoreCase(Ledger.ENTRY)) {
                        if(text!=null && !text.isEmpty())
                        ledger.setEntry(text);
                    } else if (tagName.equalsIgnoreCase(Ledger.DR)) {
                        if(text!=null && !text.isEmpty())
                        ledger.setDr(Double.parseDouble(text));
                    } else if (tagName.equalsIgnoreCase(Ledger.CR)) {
                        if(text!=null && !text.isEmpty())
                        ledger.setCr(Double.parseDouble(text));
                    } else if (tagName.equalsIgnoreCase(Ledger.AMOUNT)) {
                        if(text!=null && !text.isEmpty())
                        ledger.setAmount(Double.parseDouble(text));
                    } else if (tagName.equalsIgnoreCase(Ledger.BALANCE)) {
                        if(text!=null && !text.isEmpty())
                        ledger.setBalance(text);
                    } else if (tagName.equalsIgnoreCase(Ledger.BALANCE1)) {
                        if(text!=null && !text.isEmpty())
                        ledger.setBalance1(text);
                    } else if (tagName.equalsIgnoreCase(Ledger.MOBILE)) {
                        if(text!=null && !text.isEmpty())
                        ledger.setMobile(Long.parseLong(text));
                    }
                }

            }
            type = parser.next();
        }
        Log.e("LedgerTag","Size:"+accountList.size());
        return accountList;
    }


}
