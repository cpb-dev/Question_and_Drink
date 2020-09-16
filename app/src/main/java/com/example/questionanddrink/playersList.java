package com.example.questionanddrink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class playersList extends ArrayAdapter<players> {
        private LayoutInflater mInflater;
        private ArrayList<players> playersList;
        private int mViewResourceId;

    public playersList(Context context, int textViewResourceId, ArrayList<players> playersList) {
        super(context, textViewResourceId, playersList);
        this.playersList = playersList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents){
        convertView = mInflater.inflate(mViewResourceId,null);
        players players = playersList.get(position);

        if (players != null){
            TextView playerID = (TextView) convertView.findViewById(R.id.playerID);
            TextView playerName = (TextView) convertView.findViewById(R.id.playerName);
            TextView playerScore = (TextView) convertView.findViewById(R.id.playerScore);

            if (playerID != null){
                playerID.setText((players.getPlayerID()));
            }
            if (playerName != null){
                playerName.setText((players.getname()));
            }
        }
        return convertView;
    }

}
