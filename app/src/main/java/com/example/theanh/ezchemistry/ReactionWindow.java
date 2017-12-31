package com.example.theanh.ezchemistry;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theanh.adapter.ReactionAdapter;
import com.example.theanh.adapter.SearchReactionAdapter;
import com.example.theanh.framework.FrameWork;
import com.example.theanh.model.Graphic;
import com.example.theanh.model.Reaction;

import java.util.Arrays;

public class ReactionWindow extends AppCompatActivity {

    private ListView lvReaction, lvHistory;
    private SearchReactionAdapter leftUsingAdapter;
    private ReactionAdapter reactionAdapter;
    private TextView txtLeft, txtRight;
    private ImageView imgWayReaction;

    private MenuItem mnItem;
    private android.support.v7.widget.SearchView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_reaction_window);

        addControls();
    }

    private void addControls(){
        // create home button on action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        txtLeft = findViewById(R.id.txtLeft);
        txtRight = findViewById(R.id.txtRight);
        imgWayReaction = findViewById(R.id.imgWayReaction);

        txtLeft.setText("");
        txtRight.setText("");

        leftUsingAdapter = new SearchReactionAdapter(ReactionWindow.this, FrameWork.leftUsingList);
        lvReaction = findViewById(R.id.listReaction);
        lvReaction.setAdapter(leftUsingAdapter);

        lvHistory = findViewById(R.id.listHistory);
        reactionAdapter = new ReactionAdapter(ReactionWindow.this,R.layout.item_reaction_history, FrameWork.reactionsHistoryList);
        lvHistory.setAdapter(reactionAdapter);

        lvReaction.setVisibility(View.INVISIBLE);
        lvReaction.setEnabled(false);

        if(FrameWork.flagForReaction)
            init();

    }

    private void init(){
        FrameWork.flagForReaction = false;
        Reaction r = FrameWork.reactionTemp;
        if(r!=null){
            txtLeft.setText(r.getLeft());
            txtRight.setText(r.getRight());
            if("1".equals(r.getTwoWayReaction()))
                imgWayReaction.setImageResource(R.drawable.twowayreaction);
            FrameWork.listTemp.add(r);
        }

        FrameWork.reactionsHistoryList.clear();
        for(int i = FrameWork.listTemp.size()-1; i>=0;i--){
            FrameWork.reactionsHistoryList.add(FrameWork.listTemp.get(i));
        }

        lvHistory.deferNotifyDataSetChanged();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_menu_reaction, menu);
        searchReaction(menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void searchReaction(Menu menu){
        mnItem = menu.findItem(R.id.action_search_reaction);
        a = (android.support.v7.widget.SearchView) mnItem.getActionView();
        a.setQueryHint("ex: H20+O2");
        a.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if("".equalsIgnoreCase(newText)){
                    lvReaction.setVisibility(View.INVISIBLE);
                    lvReaction.setEnabled(false);
                }else{
                    lvReaction.setVisibility(View.VISIBLE);
                    lvReaction.setEnabled(true);

                    leftUsingAdapter.getFilter().filter(newText);
                }
                return false;
            }
        });
    }
}
