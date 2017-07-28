package com.ivblog.android.Loaderexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by surya-5034 on 28/07/17.
 */

public class TransactionAdapter extends BaseAdapter
{
    private List<Transaction> transactionList;
    private static LayoutInflater inflater=null;

    public TransactionAdapter(List<Transaction> transactions, LayoutInflater mInflater)
    {
        transactionList = transactions;
        inflater = mInflater;
    }

    @Override
    public int getCount() {
        return transactionList.size();
    }

    @Override
    public Object getItem(int position) {
        return transactionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.sing_transaction_view, null);

        TextView transactionType = (TextView)vi.findViewById(R.id.transaction_type);
        TextView transactionAmount = (TextView)vi.findViewById(R.id.transaction_amount);
        TextView transactionReason = (TextView)vi.findViewById(R.id.transaction_reason);

        Transaction transaction = transactionList.get(position);


        transactionType.setText(transaction.getTransactionType());
        transactionAmount.setText(transaction.getAmount()+"");
        transactionReason.setText(transaction.getTransactionReason());
        return vi;

    }
}
