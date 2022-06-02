package com.example.movie_recommender_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_recommender_app.Datum;
import com.example.movie_recommender_app.R;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.viewHolder>{
    Datum[] sourceData;

    public RecyclerViewAdapter2(Datum[] sourceData, Context context) {
        this.sourceData = sourceData;
        this.context = context;
    }

    Context context;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recommendation_row, parent, false);

        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Datum datum = sourceData[position];
        holder.title.setText(datum.getTitles(position));
        holder.desc.setText(datum.getDesc(position) );
       // String title = title.get(position);
       // Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();


    }

    @Override
    public int getItemCount() {
        return sourceData.length ;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView title, desc;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.descRec);
            title = itemView.findViewById(R.id.titleRec);
        }
    }
}
