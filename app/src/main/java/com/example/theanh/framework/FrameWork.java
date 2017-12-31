package com.example.theanh.framework;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.theanh.model.BackgroundColor;
import com.example.theanh.model.Element;
import com.example.theanh.model.Graphic;
import com.example.theanh.model.Reaction;
import com.example.theanh.model.TextColor;

import java.util.ArrayList;
import java.util.List;


public final class FrameWork {

    public static Element elementForDetail;

    //list of all elements
    public static List<Element> elementList;

    // list of all background color
    public static List<BackgroundColor> backgroundColorList;

    // list of all text color
    public static List<TextColor> textColorList;

    // list of all graphic
    public static List<Graphic> graphicList;

    // list of all reaction
    public static List<Reaction> reactionList;

    // list of all reaction in history list
    public static List<Reaction> reactionsHistoryList;

    // list temp of all reaction in history list
    public static List<Reaction> listTemp;

    // temp reaction for reaction window
    public static Reaction reactionTemp;

    // Left Using list
    public static ArrayList<String> leftUsingList;
    public static ArrayList<String> leftUsingList1;
    public static ArrayList<String> leftUsingList2;
    public static ArrayList<String> leftUsingList3;
    public static ArrayList<String> leftUsingList4;
    public static ArrayList<String> leftUsingList5;

    /**
     * flag for detail window
     *      if flag for detail = true
     *          reload detail window with new element
     *      else
     *          reload detail window with searched element
     */
    public static boolean flagForDetail = true;

    /**
     * flag for filter dialog
     *          if filter dialog is used, it becomes true
     *          else if become false
     */
    public static boolean flagForFilterElements = false;

    /**
     * flag for reaction window
     *      if reaction window was created, it becomes false
     *      else true
     */
    public static boolean flagForReaction = true;



    /**
     * method help to convert byte array format of image to bitmap format
     * @param image
     *      byte array of current selected element
     * @return
     *      bitmap format
     */
    public static Bitmap toBitmap(byte[] image){
        return BitmapFactory.decodeByteArray(image,0,image.length);
    }
}
