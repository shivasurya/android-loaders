package com.ivblog.android.Loaderexample;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<String>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportLoaderManager().initLoader(0, null, this);
    }


    @Override
    public Loader<List<String>> onCreateLoader(int id, Bundle args) {
        return new ZipLoader(getApplicationContext(),"/storage/sdcrd1/gov/gov_final.zip");
    }

    @Override
    public void onLoadFinished(Loader<List<String>> loader, List<String> data) {
        Log.e("data",data.size()+"");
    }

    @Override
    public void onLoaderReset(Loader<List<String>> loader) {
        Log.e("dnh","nfj");

    }


}
