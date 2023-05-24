package com.example.maclareenassignment.Note;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.maclareenassignment.Database.DatabaseManager;
import com.example.maclareenassignment.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddNoteFragment extends Fragment implements View.OnClickListener{
    Context mContext;
    TextInputEditText tiet_title;
    TextInputEditText tiet_description;
    Button btn_addnote;

    DatabaseManager databaseManager;

    String title ="",description = "";


    public AddNoteFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_note, container, false);
        mContext = getActivity();

        databaseManager = new DatabaseManager(mContext);
        databaseManager.open();

        btn_addnote = view.findViewById(R.id.btn_addnote);
        tiet_title = view.findViewById(R.id.tiet_title);
        tiet_description = view.findViewById(R.id.tiet_description);

        btn_addnote.setOnClickListener(this);



        return view;


    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if(id == R.id.btn_addnote){
            title = tiet_title.getText().toString().trim();
            description = tiet_description.getText().toString().trim();

            if(title.isEmpty()) {
                tiet_title.setError("Please Fill Title");
                tiet_title.requestFocus();
            } else if (description.isEmpty()) {
                tiet_description.setError("Please Fill Discription");
                tiet_description.requestFocus();

            } else {
                databaseManager.insertNote(title,description);
                Toast.makeText(mContext, "Data inserted", Toast.LENGTH_SHORT).show();
                tiet_title.setText("");
                tiet_description.setText("");
                NoteFragment  fragment = new NoteFragment();
                this.getFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment,null).commit();
            }


        }

    }
}