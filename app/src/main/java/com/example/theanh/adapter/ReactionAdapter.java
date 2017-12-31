package com.example.theanh.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.theanh.ezchemistry.R;
import com.example.theanh.model.Reaction;

import java.util.List;

/**
 * Created by THE ANH on 12/20/2017.
 */

public class ReactionAdapter extends ArrayAdapter<Reaction> {

    private Activity context;
    private int resource;
    private List<Reaction> objects;

    public ReactionAdapter(@NonNull Activity context, int resource, @NonNull List<Reaction> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        TextView txtLeftHistory = row.findViewById(R.id.txtLeftHistory);
        TextView txtRightHistory = row.findViewById(R.id.txtRightHistory);
        ImageView imgWayReactionHistory = row.findViewById(R.id.imgWayReactionHistory);

        final Reaction reaction = objects.get(position);
        txtLeftHistory.setText(reaction.getLeft());
        txtRightHistory.setText(reaction.getRight());
        if(Integer.parseInt(reaction.getTwoWayReaction())==1){
            imgWayReactionHistory.setImageResource(R.drawable.twowayreaction);
        }

        return row;
    }
}
