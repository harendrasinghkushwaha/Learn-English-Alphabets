package com.example.abc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AlphabetAdapter extends ArrayAdapter<Alphabet> {

    public AlphabetAdapter(Context context, int resource,List<Alphabet> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Alphabet currentAlphabet = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView alphabetImage = (ImageView) convertView.findViewById(R.id.alphbetImage);
        alphabetImage.setImageResource(currentAlphabet.getmImageOfAlphabet());
        //return super.getView(position, convertView, parent);
        return convertView;
    }
}
