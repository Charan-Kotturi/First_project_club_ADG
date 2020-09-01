package com.example.todolist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.example.todolist.SeeListItemEach.TRAINING_KEY;

public class toDoListAdaptor extends RecyclerView.Adapter<toDoListAdaptor.ViewHolder>{

    private ArrayList<studyItems> studyItems = new ArrayList<>();
    private Context context;

    public toDoListAdaptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_fixed_list, parent ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(studyItems.get(position).getName());
        holder.shortDec.setText(studyItems.get(position).getShortDec());

        Glide.with(context)
                .asBitmap()
                .load(studyItems.get(position).getImageUrl())
                .into(holder.imageUrl);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SeeListItemEach.class);
                intent.putExtra(TRAINING_KEY, studyItems.get(position));
                context.startActivity(intent);
                Toast.makeText(context, "Selected " + studyItems.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return studyItems.size();
    }

    public void setStudyItems(ArrayList<com.example.todolist.studyItems> studyItems) {
        this.studyItems = studyItems;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, shortDec;
        private ImageView imageUrl;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            shortDec = itemView.findViewById(R.id.shortDec);
            imageUrl = itemView.findViewById(R.id.imageUrl);
            parent  = itemView.findViewById(R.id.parent);
        }
    }
}
