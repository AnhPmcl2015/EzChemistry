package com.example.theanh.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.theanh.ezchemistry.R;
import com.example.theanh.framework.FrameWork;
import com.example.theanh.model.Element;
import com.example.theanh.sqliteaccess.GraphicAccess;
import com.example.theanh.sqliteaccess.SqlAccess;

import java.util.ArrayList;
import java.util.List;


public class ElementAdapter extends BaseAdapter implements Filterable {
    private Activity context;
    private List<Element> elementList;
    private LayoutInflater inflater;
    private List<Element> filterElement;

    public ElementAdapter(Activity context, List<Element> elementList){
        this.context = context;
        this.elementList = elementList;
        filterElement = elementList;
    }

    @Override
    public int getCount() {
        return elementList.size();
    }

    @Override
    public Object getItem(int position) {
        return elementList.get(position);
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
            convertView = inflater.inflate(R.layout.item_element,null);
        }

        ImageView imgSymbol_Search =convertView.findViewById(R.id.imgSymbol_Search);
        TextView txtName_Search = convertView.findViewById(R.id.txtName_Search);
        TextView txtAtomicWeight_Search = convertView.findViewById(R.id.txtAtomicWeight_Search);
        RelativeLayout layout_Search = convertView.findViewById(R.id.layout_Search);

        final Element element = this.elementList.get(position);
        imgSymbol_Search.setImageBitmap(FrameWork.toBitmap(GraphicAccess.getIcon(element.getIdGraphic())));
        txtName_Search.setText(element.getName());
        String builder = element.getAtomicWeight() + " (g/mol)";
        txtAtomicWeight_Search.setText(builder);

        layout_Search.setOnClickListener(view -> {
            FrameWork.flagForDetail = false;

            Intent intent = context.getIntent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            context.finish();
            context.startActivity(intent);

            FrameWork.elementForDetail = element;
        });
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new ValueFilter();
    }

    private class ValueFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint!=null && constraint.length() > 0){
                ArrayList<Element> filterList = new ArrayList<>();
                for(int i = 0; i < filterElement.size(); i++){
                    if(filterElement.get(i).getName().toLowerCase().contains(constraint.toString().toLowerCase())
                            || filterElement.get(i).getAtomicNumber().startsWith(constraint.toString())){
                        Element element = filterElement.get(i);
                        filterList.add(element);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            }else{
                results.count = filterElement.size();
                results.values = filterElement;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            elementList = (List<Element>) results.values;
            notifyDataSetChanged();
        }
    }
}
