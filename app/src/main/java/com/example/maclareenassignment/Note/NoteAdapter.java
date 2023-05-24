package com.example.maclareenassignment.Note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maclareenassignment.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{

    private ArrayList<NoteModel> noteModelArrayList;
    private Context context;
    View.OnClickListener onClickListener;

    public NoteAdapter(Context mContext, ArrayList<NoteModel> noteModelList, View.OnClickListener  onClickListener) {
        this.context = mContext;
        this.noteModelArrayList = noteModelList;
        this.onClickListener = onClickListener;


    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_adapter,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        NoteModel model = noteModelArrayList.get(position);
        holder.tv_title.setText(model.getTitle());
        holder.tv_description.setText(model.getDescription());
        holder.tv_creationDate.setText(model.getCreated_at());


    }

    @Override
    public int getItemCount() {
        return noteModelArrayList.size();
    }


    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_description;
        TextView tv_creationDate;
        TextView tv_menu;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_creationDate = itemView.findViewById(R.id.tv_creationDate);
            tv_menu = itemView.findViewById(R.id.tv_menu);



        }
    }


}
