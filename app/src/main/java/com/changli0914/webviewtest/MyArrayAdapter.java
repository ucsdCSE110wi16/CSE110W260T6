package com.changli0914.webviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Customized ArrayAdapter to Show Pairs in the Main Screen
 * Created by Chang Li on 2016/2/9 0009.
 */
public class MyArrayAdapter extends ArrayAdapter<Pair> {

    protected final Context context;
    protected final List<Pair> pairList;

    /** Constructor */
    public MyArrayAdapter(Context context, List<Pair> pairList) {
        super(context, -1, pairList);
        this.context =context;
        this.pairList = pairList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.pairlist_layout, parent, false);
        Pair pair = pairList.get(position);

        /** Set the view for one item */
        TextView title = (TextView) rowView.findViewById(R.id.item_title);
        title.setText(pair.title);
        TextView subtitle1 = (TextView) rowView.findViewById(R.id.item_subtitle1);
        subtitle1.setText(pair.news1.title);
        TextView subtitle2 = (TextView) rowView.findViewById(R.id.item_subtitle2);
        subtitle2.setText(pair.news2.title);
        ImageView image = (ImageView) rowView.findViewById(R.id.item_image);
        image.setImageResource(pair.image);
        ImageView sourceImage1 = (ImageView) rowView.findViewById(R.id.item_source_image1);
        switch (pair.news1.source) {
            case ABC:
                sourceImage1.setImageResource(R.drawable.abcnews);
                break;
            case BBC:
                sourceImage1.setImageResource(R.drawable.bbcnews);
                break;
            case Fox:
                sourceImage1.setImageResource(R.drawable.foxnews);
                break;
            case Yahoo:
                sourceImage1.setImageResource(R.drawable.yahoonews);
                break;
            case Other:
                sourceImage1.setImageResource(R.drawable.othernews);
                break;
        }
        ImageView sourceImage2 = (ImageView) rowView.findViewById(R.id.item_source_image2);
        switch (pair.news2.source) {
            case ABC:
                sourceImage2.setImageResource(R.drawable.abcnews);
                break;
            case BBC:
                sourceImage2.setImageResource(R.drawable.bbcnews);
                break;
            case Fox:
                sourceImage2.setImageResource(R.drawable.foxnews);
                break;
            case Yahoo:
                sourceImage2.setImageResource(R.drawable.yahoonews);
                break;
            case Other:
                sourceImage2.setImageResource(R.drawable.othernews);
                break;
        }

        return rowView;
    }
}
