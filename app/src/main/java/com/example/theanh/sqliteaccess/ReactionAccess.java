package com.example.theanh.sqliteaccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.theanh.framework.FrameWork;
import com.example.theanh.model.Reaction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public final class ReactionAccess {
    public static List<Reaction> getAllReaction(Context context){
        List<Reaction> list = new ArrayList<>();
        Reaction reaction;
        String DATABASE_NAME = "EzChemistry.sqlite";

        SQLiteDatabase database = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("Select * from reaction", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            reaction = new Reaction();
            reaction.setLeft(cursor.getString(0));
            reaction.setRight(cursor.getString(1));
            reaction.setTwoWayReaction(cursor.getString(2));
            reaction.setLeftUsing(cursor.getString(3));
            reaction.setLeftUsing1(cursor.getString(4));
            reaction.setLeftUsing2(cursor.getString(5));
            reaction.setLeftUsing3(cursor.getString(6));
            reaction.setLeftUsing4(cursor.getString(7));
            reaction.setLeftUsing5(cursor.getString(8));
            list.add(reaction);
            cursor.moveToNext();
        }

        return list;
    }

    public static void getAllLeftUsing(List<Reaction> list){
        FrameWork.leftUsingList = new ArrayList<>();
        FrameWork.leftUsingList1 = new ArrayList<>();
        FrameWork.leftUsingList2 = new ArrayList<>();
        FrameWork.leftUsingList3 = new ArrayList<>();
        FrameWork.leftUsingList4 = new ArrayList<>();
        FrameWork.leftUsingList5 = new ArrayList<>();

        for(Reaction reaction : list){
            FrameWork.leftUsingList.add(reaction.getLeftUsing());
            FrameWork.leftUsingList1.add(reaction.getLeftUsing1());
            FrameWork.leftUsingList2.add(reaction.getLeftUsing2());
            FrameWork.leftUsingList3.add(reaction.getLeftUsing3());
            FrameWork.leftUsingList4.add(reaction.getLeftUsing4());
            FrameWork.leftUsingList5.add(reaction.getLeftUsing5());

        }
    }
}
