package com.example.theanh.sqliteaccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.theanh.framework.FrameWork;
import com.example.theanh.model.BackgroundColor;

import java.util.ArrayList;
import java.util.List;

public class BackgroundColorAccess {

    /**
     * method help get background color duplicate match id of background color
     */

    public static String getBackgroundColor(String id_Background_Color){
        return FrameWork.backgroundColorList.get(Integer.parseInt(id_Background_Color) - 1).getColorHex();
    }

    /**
     * method help to get list background color
     * @param context
     * @return
     */

    public static List<BackgroundColor> getListBackgroundColor(Context context){
        List<BackgroundColor> list = new ArrayList<>();
        BackgroundColor backgroundColor;
        String DATABASE_NAME = "EzChemistry.sqlite";

        SQLiteDatabase database = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("Select * from Background_Color", null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            backgroundColor = new BackgroundColor();
            backgroundColor.setIdBackgroundColor(cursor.getString(0));
            backgroundColor.setColorHex(cursor.getString(1));
            backgroundColor.setName(cursor.getString(2));
            list.add(backgroundColor);
            cursor.moveToNext();
        }

        database.close();
        cursor.close();
        return list;
    }
}
