package com.ivblog.android.Loaderexample;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by ADMIN on 22-02-2017.
 */

public class ZipLoader extends android.support.v4.content.AsyncTaskLoader<List<String>> {

    private List<String> mFiles;
    private Context mContext;
    private String mFileName;

    public ZipLoader(Context context,String fileName) {
        super(context);
        mContext = context;
        mFileName = fileName;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<String> loadInBackground() {
        mFiles = new ArrayList<>();
        Log.e("hgjer","jhdk");

        try{
            File file = new File(mFileName);
            ZipFile zipFile = new ZipFile(file);
            Enumeration zipEntries = zipFile.entries();
            while (zipEntries.hasMoreElements()) {
                String fileName = ((ZipEntry) zipEntries.nextElement()).getName();
                mFiles.add(fileName);
            }
            zipFile.close();
            return  mFiles;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
