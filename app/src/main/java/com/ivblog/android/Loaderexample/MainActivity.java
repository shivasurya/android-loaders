package com.ivblog.android.Loaderexample;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Transaction>> {

    private ListView transactionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadAllViewsById();
        getSupportLoaderManager().initLoader(0, null, this);
    }

    private void loadAllViewsById()
    {
        transactionList = (ListView) findViewById(R.id.transaction_list);
    }


    @Override
    public Loader<List<Transaction>> onCreateLoader(int id, Bundle args) {
        return new CSVLoader(getApplicationContext());
    }

    @Override
    public void onLoadFinished(Loader<List<Transaction>> loader, List<Transaction> data) {
        //finished -> ui updates
        if(data!= null && data.size() > 0)
        {
            TransactionAdapter trasactionAdapter = new TransactionAdapter(data,getLayoutInflater());
            transactionList.setAdapter(trasactionAdapter);
        }
        else
        {
            //show empty UI text
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Transaction>> loader) {
        // reset
    }
}
