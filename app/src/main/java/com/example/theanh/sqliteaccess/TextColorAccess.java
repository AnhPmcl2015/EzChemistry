package com.example.theanh.sqliteaccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.theanh.framework.FrameWork;
import com.example.theanh.model.TextColor;

import java.util.ArrayList;
import java.util.List;


public class TextColorAccess {
    /**
     * method help get text color duplicate match id of text color
     */

    public static String getTextColor(String id_Text_Color){
        return FrameWork.textColorList.get(Integer.parseInt(id_Text_Color) - 1).getColorHex();
    }

    /**
     * method help to get list text color
     * @param context
     * @return
     */

    public static List<TextColor> getListTextColor(Context context){
        List<TextColor> list = new ArrayList<>();
        TextColor textColor;
        String DATABASE_NAME = "EzChemistry.sqlite";

        SQLiteDatabase database = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("Select * from Text_Color", null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            textColor = new TextColor();
            textColor.setIdTextColor(cursor.getString(0));
            textColor.setColorHex(cursor.getString(1));
            textColor.setName(cursor.getString(2));
            list.add(textColor);
            cursor.moveToNext();
        }
        database.close();
        cursor.close();
        return list;
    }
}
