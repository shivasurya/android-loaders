package com.ivblog.android.Loaderexample;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivasurya S on 28/07/17.
 */

public class CSVLoader extends AsyncTaskLoader<List<Transaction>>
{
    List<Transaction> transactionList;
    String csvFile;
    BufferedReader br;
    String line;
    String cvsSplitBy;

    public CSVLoader(Context context)
    {
        super(context);
        transactionList = new ArrayList<>();
        csvFile = "/sdcard/sample/transaction.csv";
        br = null;
        line = "";
        cvsSplitBy = ",";
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<Transaction> loadInBackground()
    {
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
            {
                Transaction transaction = new Transaction();
                String[] transactionHolder = line.split(cvsSplitBy);

                // id
                transaction.setId(Integer.parseInt(transactionHolder[0]));

                // transaction type
                transaction.setTransactionType(transactionHolder[1]);

                //transaction amount
                transaction.setAmount(Double.parseDouble(transactionHolder[2]));

                //transaction reason
                transaction.setTransactionReason(transactionHolder[3]);

                transactionList.add(transaction);

            }
            br.close();

        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
       return transactionList;
    }
}
