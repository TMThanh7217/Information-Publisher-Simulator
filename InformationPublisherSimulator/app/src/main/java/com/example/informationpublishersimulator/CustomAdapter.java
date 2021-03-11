package com.example.informationpublishersimulator;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

class CustomAdapter extends ArrayAdapter<User> {
    Context context; Integer[] thumbnails; ArrayList<User> informs;
    public CustomAdapter(Context context, int layoutToBeInflated, ArrayList<User> informs, Integer[] thumbnails) {
        super(context, R.layout.row_layout, informs);
        this.context = context;
        this.thumbnails = thumbnails;
        this.informs = informs;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.row_layout, null);
        TextView textViewId = (TextView) row.findViewById(R.id.textViewId);
        TextView  textViewName = (TextView) row.findViewById(R.id.textViewName);
        TextView textViewClass = (TextView) row.findViewById(R.id.textViewClass);
        TextView textViewMark = (TextView) row.findViewById(R.id.textViewMark);

        ImageView icon = (ImageView) row.findViewById(R.id.icon);
        textViewId.setText(informs.get(position).id);
        textViewName.setText(informs.get(position).name);
        textViewClass.setText(informs.get(position).className);
        textViewMark.setText(informs.get(position).mark.toString());
        icon.setImageResource(thumbnails[position]);
        return (row);
    }
} // CustomAdapter