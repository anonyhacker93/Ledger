package com.example.ledger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ledger.model.Account;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XmlParser xmlParser = new XmlParser();
        List<Account> accountList;
        try {
            InputStream is = getAssets().open("Collection.xml");
            accountList = xmlParser.parse(is);
            Log.e("LedgerTag","Size:"+accountList.size());
        } catch (Exception ex) {
            Log.e("LedgerTag", "MainActivity onCreate:" + ex);
        }
    }
}
