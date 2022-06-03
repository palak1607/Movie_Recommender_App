package com.example.movie_recommender_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_recommender_app.DisplayRecommend;
import com.example.movie_recommender_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;

    LayoutInflater inflater;
    List<String> titles, descriptions, imageUrl;


    public RecyclerViewAdapter(Context context, List<String> titles, List<String> descriptions, List<String>imageUrl){
        this.inflater = LayoutInflater.from(context );
        this.titles=titles;
        this.descriptions=descriptions ;
        this.imageUrl = imageUrl ;
        this.context = context;

        //Log.d("TAG", "Adapter: "+titles);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = inflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = titles.get(position);
        String desc = descriptions.get(position);
        String img = imageUrl.get(position);

        holder.title.setText(title);
        holder.content.setText(desc);
        // using picasso to download and display image
        Picasso.get().load(img).into(holder.listImg);


    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView listImg;
        TextView title, content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listImg = itemView.findViewById(R.id.listImage);
            title =   itemView.findViewById(R.id.dataTitle);                                //
            content = itemView.findViewById(R.id.dataDescription);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int pos= this.getBindingAdapterPosition() ;

            //Toast.makeText(context, "The position is "+ pos, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, DisplayRecommend.class);
            TextView titleDisplay = (TextView) title;                                       //
            TextView descDisplay = (TextView) content;
            String message1 = titleDisplay.getText().toString();
            String message2 = descDisplay.getText().toString();
            intent.putExtra("TITLE", message1);
            intent.putExtra("DESC" , message2);
           context.startActivity(intent);

        }
    }
}
