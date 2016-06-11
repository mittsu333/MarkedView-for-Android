package com.mittsu.markedviewlib;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by mittsu on 2016/05/23.
 * assets copy to app directory.
 */
public final class FileCopyManager {

    private static final String TAG = FileCopyManager.class.getSimpleName();

    public FileCopyManager(Context c){
        copyAsset2AppDir(c);
    }

    public String getSampleFilePath(Context c){
        return c.getFilesDir() + "/sample.md";
    }

    private void copyAsset2AppDir(Context c){
        String[] asFiles = new String[]{};
        AssetManager am = c.getResources().getAssets();

        try{
            asFiles = am.list("sample_data");
        }catch(IOException e){
            Log.e(TAG, "get file from assets error.\n" + e);
        }

        for(String file : asFiles){

            BufferedInputStream inputStream = null;
            BufferedOutputStream outStream = null;

            try{
                inputStream = new BufferedInputStream(am.open("sample_data/" + file));
                FileOutputStream saveFile = c.openFileOutput(file, Context.MODE_PRIVATE);
                outStream = new BufferedOutputStream(saveFile);

                copyFile(inputStream, outStream);

            } catch (FileNotFoundException e) {
                Log.e(TAG, "FileNotFoundException:" + e);
            } catch (IOException e) {
                Log.e(TAG, "IOException:" + e);
            } finally {
                streamClose(inputStream, outStream);
            }
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024 * 1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    private void streamClose(InputStream in, OutputStream out){
        try {
            if(in != null) in.close();
            if(out != null) out.close();
        } catch (IOException e) {
            Log.e(TAG, "IOException:" + e);
        }
    }

}
