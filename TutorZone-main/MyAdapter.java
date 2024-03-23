package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<information> informationlist;

    public MyAdapter(Context context) {
        this.context = context;
        informationlist=new ArrayList<>();
    }
    public void add(information Information)  {
        informationlist.add(Information);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_item2,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        information Information=informationlist.get(position);
        holder.title.setText(Information.getTitle());
        holder.subject.setText(Information.getSubject());
        holder.location.setText(Information.getLocation());
        holder.fee.setText(Information.getFee());
        holder.others.setText(Information.getOthers());
        holder.contact.setText(Information.getContact());

    }

    @Override
    public int getItemCount() {

        return informationlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title,subject,location,fee,contact,others;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.note_title_text_view2);
            subject=itemView.findViewById(R.id.subject2);
            location=itemView.findViewById(R.id.location2);
            fee=itemView.findViewById(R.id.fee2);
            others=itemView.findViewById(R.id.others2);
         contact=itemView.findViewById(R.id.contact2);
        }
    }
}
