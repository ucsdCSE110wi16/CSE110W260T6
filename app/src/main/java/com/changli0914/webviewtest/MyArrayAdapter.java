package com.changli0914.webviewtest;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
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
    public View getView(int position, View convertView, final ViewGroup parent) {
         //inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = convertView; //= inflater.inflate(R.layout.pairlist_layout, parent, false);
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            rowView = inflater.inflate(R.layout.pairlist_layout, null);
        }


        final Pair pair = pairList.get(position);
        final View.OnClickListener pairJumpHandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                /** Transmit the Target Pair to the PairViewActivity */
                intent.putExtra("pairID", pair.getObjectId());
                intent.setClass(getContext(), PairViewActivity.class);
                /** Start The PairViewActivity */
                getContext().startActivity(intent);
            }
        };

        /** Set the view for one item */
        // Title
        TextView title = (TextView) rowView.findViewById(R.id.item_title);
        title.setText(pair.getTitle());
        // Like Count
        final TextView likeCount = (TextView)rowView.findViewById(R.id.textView_likecount);
        likeCount.setText(pair.getLikeCount() + "");
        // Like Button
        final ImageButton likeButton = (ImageButton)rowView.findViewById(R.id.imageButton_like);
        likeButton.setTag(false);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(Boolean)likeButton.getTag()) {
                    pair.increment("likeCount");
                    pair.saveInBackground();
                    likeButton.setTag(true);
                    likeCount.setText(pair.getLikeCount() + "");
                    likeButton.setImageResource(R.drawable.icon_liked);
                } else {
                    pair.increment("likeCount", -1);
                    pair.saveInBackground();
                    likeButton.setTag(false);
                    likeCount.setText(pair.getLikeCount() + "");
                    likeButton.setImageResource(R.drawable.icon_like);
                }
            }
        });
        // Subtitle 1
        TextView subtitle1 = (TextView) rowView.findViewById(R.id.item_subtitle1);
        subtitle1.setText(pair.getTitle(1));
        subtitle1.setOnClickListener(pairJumpHandler);
        // Subtitle 2
        TextView subtitle2 = (TextView) rowView.findViewById(R.id.item_subtitle2);
        subtitle2.setText(pair.getTitle(2));
        subtitle2.setOnClickListener(pairJumpHandler);
        // Image
        ImageView image = (ImageView) rowView.findViewById(R.id.item_image);
        image.setImageResource(pair.getImage());
        image.setOnClickListener(pairJumpHandler);
        // News Source Image 1
        ImageView sourceImage1 = (ImageView) rowView.findViewById(R.id.item_source_image1);
        sourceImage1.setOnClickListener(pairJumpHandler);
        switch (pair.getSource(1)) {
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
        // News Source Image 2
        ImageView sourceImage2 = (ImageView) rowView.findViewById(R.id.item_source_image2);
        sourceImage2.setOnClickListener(pairJumpHandler);
        switch (pair.getSource(2)) {
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
