package com.example.digitlog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter4 extends RecyclerView.Adapter<MyRecyclerViewAdapter4.ViewHolder> {

    //Trip_Class(     String load,     String fuel,     String user_2,    String comment,   String datetime,     String alarms)
    private int textSize;
    private ArrayList<E_Status> mExampleList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    List<String> status, user, comment, datetime;

    // data is passed into the constructor
    MyRecyclerViewAdapter4(Context context, List<String> status, List<String> user,
                           List<String> comment, List<String> datetime) {

        this.mInflater = LayoutInflater.from(context);
        this.status = status;
        this.user = user;
        this.datetime = datetime;
        this.comment = comment;
        this.textSize = 10;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row3, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        E_Status current_item = mExampleList.get(position);
/*
        String category_s = category.get(position);
        String urgency_s = urgency.get(position);
        String user_s = user.get(position);
        String comment_s = comment.get(position);
        String datetime_s = datetime.get(position);
*/
            holder.category_tv.setText(current_item.getStatus());
            holder.user_tv.setText(current_item.getUser());
            holder.comment_tv.setText(current_item.getDescription());
            holder.datetime_tv.setText(current_item.getDatetime());

        /**
         holder.category_tv.setText(category_s);
         holder.urgency_tv.setText(urgency_s);
         holder.user_tv.setText(user_s);
         holder.comment_tv.setText(comment_s);
         holder.datetime_tv.setText(datetime_s);
         **/
    }

    // total number of rows
    @Override
    public int getItemCount() {
        try {
            return mExampleList.size();
            // return category.size();
        }catch (Exception ex) {
            return 0;
        }
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView datetime_tv, category_tv, user_tv, comment_tv;

        ViewHolder(View itemView) {
            super(itemView);
            category_tv = itemView.findViewById(R.id.fault9);
            datetime_tv = itemView.findViewById(R.id.date9);
            comment_tv = itemView.findViewById(R.id.comment9);
            user_tv = itemView.findViewById(R.id.user9);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (mClickListener != null){
                mClickListener.onItemClick(view, getAdapterPosition());
            };
        }
    }

    // convenience method for getting data at click position
    String getItem(List<String> category2, int id) {
        //return mExampleList.get(id);
        return category2.get(id);
    }

    String getItem2(List<String> category2,int id) {
        //return mExampleList.get(id);
        return category2.get(id);
    }

    String getItem3(List<String> category2,int id) {
        //return mExampleList.get(id);
        return category2.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    public MyRecyclerViewAdapter4(ArrayList<E_Status> exampleList) {
        mExampleList = exampleList;

    }

    public void filterList(ArrayList<E_Status> filteredList) {
        mExampleList = filteredList;
        notifyDataSetChanged();
    }
}