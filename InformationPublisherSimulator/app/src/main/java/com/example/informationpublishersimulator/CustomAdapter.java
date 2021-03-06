package com.example.informationpublishersimulator;

import android.annotation.SuppressLint;
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
        System.out.println("CustomAdapter.CreAte");
        this.context = context;
        this.thumbnails = thumbnails;
        this.informs = informs;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("CustomAdapter.getView");
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.row_layout, null);
        TextView textViewId = (TextView) row.findViewById(R.id.userId);
        ImageView imageViewIcon = (ImageView) row.findViewById(R.id.icon);

        ImageView icon = (ImageView) row.findViewById(R.id.icon);
        textViewId.setText(informs.get(position).id);
        icon.setImageResource(thumbnails[position]);
        return (row);
    }
} // CustomAdapter