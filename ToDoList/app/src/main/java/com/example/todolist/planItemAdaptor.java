package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.todolist.SeeListItemEach.TRAINING_KEY;

public class planItemAdaptor extends RecyclerView.Adapter<planItemAdaptor.ViewHolder> {

    private ArrayList<Plan> plans = new ArrayList<>();
    private Context mContext;

    public planItemAdaptor(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.txtPlanItemName.setText(plans.get(position).getStudyItems().getName());
        holder.txtDay.setText(plans.get(position).getDay());
        holder.txtMinutes.setText(String.valueOf(plans.get(position).getMinutes()));

        if(plans.get(position).isAccomplished()){
            holder.checkedCircle.setVisibility(View.VISIBLE);
            holder.UncheckedCircle.setVisibility(View.GONE);
        }
        else{
            holder.checkedCircle.setVisibility(View.GONE);
            holder.UncheckedCircle.setVisibility(View.VISIBLE);
        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,SeeListItemEach.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(TRAINING_KEY, plans.get(position).getStudyItems());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtPlanItemName, txtMinutes, txtDay;
        private ImageView checkedCircle,UncheckedCircle;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDay = itemView.findViewById(R.id.txtDay);
            txtMinutes = itemView.findViewById(R.id.txtMinutes);
            txtPlanItemName = itemView.findViewById(R.id.txtPlanItemName);
            checkedCircle = itemView.findViewById(R.id.CheckedImage);
            UncheckedCircle = itemView.findViewById(R.id.unCheckedImage);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
