package com.example.juliodebuen.excercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.juliodebuen.excercise.model.Exercise;


import java.util.ArrayList;


public class RoutineAdapter extends ArrayAdapter<Exercise> {

    public RoutineAdapter(ArrayList<Exercise> exercises, Context context) {
        super(context, R.layout.listview_excercise, exercises);
    }

    public static class ViewHolder{
        TextView tName;
        TextView tSeries;
        TextView tReps;
        TextView tWeight;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Exercise exercise = getItem(position);
        ViewHolder vh = new ViewHolder();
        if(convertView == null){
            LayoutInflater inflater =  LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_excercise, null);
        }

        if(exercise != null){
            vh.tName = convertView.findViewById(R.id.tName);
            vh.tSeries = convertView.findViewById(R.id.tSeries);
            vh.tReps = convertView.findViewById(R.id.tReps);
            vh.tWeight = convertView.findViewById(R.id.tWeight);
            vh.tName.setText(exercise.getName());
        //    vh.tSeries.setText(String.valueOf(exercise.getSerie()));
         //   vh.tReps.setText(String.valueOf(exercise.getReps()));
         ///   vh.tWeight.setText(String.valueOf(exercise.getWeight()));
        }
        return convertView;
    }
}
