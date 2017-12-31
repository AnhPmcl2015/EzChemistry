package com.example.theanh.sqliteaccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.theanh.model.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public final class SqlAccess {

    /* Information of database*/
    private static String DATABASE_NAME = "EzChemistry.sqlite";
    private static String DB_PATH_SUFFIX = "/databases/";


    /**
     * 3 method help copy database from asset file to system
     *      It help application run faster cause it only needs load database 1 time at the first time
     *      after installation finish
     * @param context
     *      current activity
     */

    public static void copyDatabaseFromAssetToSystem(Context context){
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists()){
            try{
                CopyDataBaseFromAsset(context);
                Toast.makeText(context,"OK", Toast.LENGTH_SHORT).show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private static void CopyDataBaseFromAsset(Context context) {
        try{
            InputStream myInput = context.getAssets().open(DATABASE_NAME);
            String outFileName = takeDatabasePath(context);
            File f = new File(context.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }

            OutputStream myOutput = new FileOutputStream(outFileName);
            byte [] buffer = new byte[10240];
            int length;
            while((length = myInput.read(buffer)) > 0){
                myOutput.write(buffer, 0, length);
            }

            myOutput.flush();
            myOutput.close();
            myInput.close();
        }catch(Exception ex){
            Log.e("Copy error", ex.toString());
        }
    }

    private static String takeDatabasePath(Context context){
        return context.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }



}
