package com.example.theanh.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theanh.ezchemistry.R;
import com.example.theanh.framework.FrameWork;
import com.example.theanh.model.Reaction;

import java.util.ArrayList;
import java.util.List;


public class SearchReactionAdapter extends BaseAdapter implements Filterable {

    private Activity context;
    private List<String> reactionList;
    private LayoutInflater inflater;
    private List<String> filterReaction;

    public SearchReactionAdapter(Activity context, List<String> reactionList){
        this.context = context;
        this.reactionList = reactionList;
        this.filterReaction = reactionList;
    }

    @Override
    public int getCount() {
        return reactionList.size();
    }

    @Override
    public Object getItem(int position) {
        return reactionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_textview_color,null);
        }

        TextView txt = convertView.findViewById(R.id.textViewColor);
        LinearLayout linearLayout = convertView.findViewById(R.id.linearLayoutReaction);

        String temp = this.reactionList.get(position);
        txt.setText(temp);
        linearLayout.setOnClickListener(e->{
            FrameWork.flagForReaction = true;
            for(Reaction r : FrameWork.reactionList)
                if(temp.equalsIgnoreCase(r.getLeftUsing())) {
                    FrameWork.reactionTemp = r;
                    Intent intent = context.getIntent();
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    context.finish();
                    context.startActivity(intent);
                    break;
                }
        });
        return convertView;
    }

    @Override
    public android.widget.Filter getFilter() {
        return new ValueFilter();
    }

    private class ValueFilter extends android.widget.Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            String temp;
            if(constraint!=null && constraint.length()>0){
                ArrayList<String> filterList = new ArrayList<>();
                temp = constraint.toString();
                for(int i = 0; i < filterReaction.size(); i++){
                    if(filterReaction.get(i).toLowerCase().contains(temp.toLowerCase())){
                        filterList.add(filterReaction.get(i));
                    }
                    else{
                        if(FrameWork.leftUsingList1.get(i).toLowerCase().contains(temp.toLowerCase()))
                            filterList.add(filterReaction.get(i));
                        else{
                            if(FrameWork.leftUsingList2.get(i).toLowerCase().contains(temp.toLowerCase()))
                                filterList.add(filterReaction.get(i));
                            else{
                                if(FrameWork.leftUsingList3.get(i).toLowerCase().contains(temp.toLowerCase()))
                                    filterList.add(filterReaction.get(i));
                                else{
                                    if(FrameWork.leftUsingList4.get(i).toLowerCase().contains(temp.toLowerCase()))
                                        filterList.add(filterReaction.get(i));
                                    else{
                                        if(FrameWork.leftUsingList5.get(i).toLowerCase().contains(temp.toLowerCase()))
                                            filterList.add(filterReaction.get(i));
                                    }
                                }
                            }
                        }
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            }else{
                results.count = filterReaction.size();
                results.values = filterReaction;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            reactionList = (List<String>) results.values;
            notifyDataSetChanged();
        }
    }
}
