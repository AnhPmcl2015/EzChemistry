package com.example.theanh.sqliteaccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.theanh.framework.FrameWork;
import com.example.theanh.model.Graphic;

import java.util.ArrayList;
import java.util.List;


public class GraphicAccess {
    private static Graphic getGraphic(String idGraphic){
        return FrameWork.graphicList.get(Integer.parseInt(idGraphic) - 1);
    }
    /**
     * method help get id of background color
     */

    public static String getIdBackgroundColor(String idGraphic){
        return getGraphic(idGraphic).getIdBackgroundColor();
    }

    /**
     * method help get id of text color
     */

    public static String getIdTextColor(String idGraphic){
        return getGraphic(idGraphic).getIdTextColor();
    }

    /**
     * method help get image
     */

    public static byte[] getImage(String idGraphic){
        return getGraphic(idGraphic).getImage();
    }

    /**
     * method help get icon
     */

    public static byte[] getIcon(String idGraphic){
        return getGraphic(idGraphic).getIcon();
    }
    /**
     * method help to get list of graphic
     * @param context
     * @return
     */

    public static List<Graphic> getListGraphic(Context context){
        List<Graphic> list = new ArrayList<>();
        Graphic graphic = null;
        String DATABASE_NAME = "EzChemistry.sqlite";

        SQLiteDatabase database = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("Select * from Graphic", null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            graphic = new Graphic();
            graphic.setIdGraphic(cursor.getString(0));
            graphic.setImage(cursor.getBlob(1));
            graphic.setIcon(cursor.getBlob(2));
            graphic.setIdBackgroundColor(cursor.getString(3));
            graphic.setIdTextColor(cursor.getString(4));
            list.add(graphic);
            cursor.moveToNext();
        }
        database.close();
        cursor.close();
        return list;
    }
}
