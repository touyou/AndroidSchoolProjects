package com.dev.touyou.flashcardplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by touyou on 2016/10/17.
 */
public class CardAdapter extends ArrayAdapter<Card> {
    List<Card> mCards;

    public CardAdapter(Context context, int layoutResourceId, List<Card> objects) {
        super(context, layoutResourceId, objects);

        mCards = objects;
    }

    @Override
    public int getCount() {
        return mCards.size();
    }

    @Override
    public Card getItem(int position) {
        return mCards.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Card item = getItem(position);

        if (item != null) {
            viewHolder.iconImageView.setImageResource(item.imageId);
            viewHolder.titleTextView.setText(item.title);
            viewHolder.contentTextView.setText(item.content);
            viewHolder.likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.likeNum++;
                    viewHolder.likeTextView.setText(item.likeNum+" Likes");
                    Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.like_touch);
                    viewHolder.likeButton.startAnimation(animation);
                    viewHolder.likeButton.setImageResource(R.drawable.ic_favorite_black_24dp);
                }
            });
            viewHolder.iconImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), item.meaning, Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }

    private class ViewHolder {
        ImageView iconImageView;
        TextView titleTextView;
        TextView likeTextView;
        TextView contentTextView;
        ImageView likeButton;

        public ViewHolder(View v) {
            iconImageView = (ImageView) v.findViewById(R.id.icon);
            titleTextView = (TextView) v.findViewById(R.id.title_textview);
            likeTextView = (TextView) v.findViewById(R.id.like_textview);
            contentTextView = (TextView) v.findViewById(R.id.content);
            likeButton = (ImageView) v.findViewById(R.id.like_button);
        }
    }
}
