package com.example.theanh.ezchemistry;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.theanh.framework.FrameWork;
import com.example.theanh.sqliteaccess.BackgroundColorAccess;
import com.example.theanh.sqliteaccess.ElementAccess;
import com.example.theanh.sqliteaccess.GraphicAccess;
import com.example.theanh.sqliteaccess.ReactionAccess;
import com.example.theanh.sqliteaccess.SqlAccess;
import com.example.theanh.sqliteaccess.TextColorAccess;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //thread for displaying the SplashScreen
        handler = new Handler();
        handler.postDelayed(() -> {
            Intent screen = new Intent(MainActivity.this, EzChemistry.class);
            startActivity(screen);
            finish();
        },3000);

        //copyDatabaseFromAssetToSystem();
        SqlAccess.copyDatabaseFromAssetToSystem(MainActivity.this);

        FrameWork.elementList = (ElementAccess.getListElement(MainActivity.this));
        FrameWork.graphicList = (GraphicAccess.getListGraphic(MainActivity.this));
        FrameWork.backgroundColorList = (BackgroundColorAccess.getListBackgroundColor(MainActivity.this));
        FrameWork.textColorList = (TextColorAccess.getListTextColor(MainActivity.this));
        FrameWork.reactionList = (ReactionAccess.getAllReaction(MainActivity.this));
        ReactionAccess.getAllLeftUsing(FrameWork.reactionList);
        FrameWork.reactionsHistoryList = new ArrayList<>();
        FrameWork.listTemp = new ArrayList<>();
    }


}
