package com.example.coriander;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ThreeColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater uInflator;
    private ArrayList<User> users;
    private int uViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<User> users){
        super(context, textViewResourceId,  users);
        this.users = users;
        uInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        uViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents){
        convertView = uInflator.inflate(uViewResourceId,null);
        User user = users.get(position);

        if(user != null){
            TextView name = (TextView) convertView.findViewById(R.id.textView31);
            TextView number = (TextView) convertView.findViewById(R.id.textView32);

            if(name != null){
                name.setText(user.getName());
            }

            if(number != null){
                number.setText(user.getNumber());
            }
        }
        return convertView;
    }

}
