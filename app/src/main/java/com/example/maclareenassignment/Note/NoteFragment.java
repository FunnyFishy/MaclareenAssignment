package com.example.maclareenassignment.Note;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maclareenassignment.Database.DatabaseManager;
import com.example.maclareenassignment.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NoteFragment extends Fragment implements View.OnClickListener{
    RecyclerView rv_noteList;
    FloatingActionButton fab_addnote;
    Context mContext;

    DatabaseManager databaseManager;

    NoteAdapter noteAdapter;
    ArrayList<NoteModel> noteModelList;
//    Fragment fragment;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note,container,false);
        mContext = getActivity();



        databaseManager = new DatabaseManager(mContext);
//        databaseManager.open();
        noteModelList = new ArrayList<>();

        noteModelList = databaseManager.fetchNotes();

        rv_noteList = view.findViewById(R.id.rv_noteList);
        fab_addnote = view.findViewById(R.id.fab_addnote);

        fab_addnote.setOnClickListener(this);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        rv_noteList.setLayoutManager(layoutManager);
        noteAdapter = new NoteAdapter(mContext,noteModelList, this);
        rv_noteList.setItemAnimator(new DefaultItemAnimator());
        rv_noteList.setAdapter(noteAdapter);







        return view;
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id){
            case R.id.fab_addnote:
             AddNoteFragment  fragment = new AddNoteFragment();
             this.getFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment,null).commit();

        }


    }
}
