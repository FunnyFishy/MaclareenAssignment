package com.example.maclareenassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.maclareenassignment.Note.NoteFragment;
import com.example.maclareenassignment.Setting.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG ="MainActivity";


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    BottomNavigationView bottom_navigation;
    NavigationView  navigationView;


    FragmentManager fragmentManager;
    Fragment fragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        drawerLayout = findViewById(R.id.drawerLayout);
        bottom_navigation = findViewById(R.id.bottom_navigation);
        navigationView = findViewById(R.id.NavigationView);




        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        (getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();
        replaceFragment(new NoteFragment());



        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.notes:
                        //Toast.makeText(MainActivity.this, "I am note ", Toast.LENGTH_SHORT).show();
                        replaceFragment(new NoteFragment());

                        return true;
                    case R.id.setting:

                        replaceFragment(new SettingFragment());

                        return true;

                }
                return true;
            }
        });


//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()){
//                    case R.id.notes:
//                        Toast.makeText(MainActivity.this, "I am note1 ", Toast.LENGTH_SHORT).show();
//                        replaceFragment(new NoteFragment());
//
//                        return true;
//                    case R.id.setting:
//                        replaceFragment(new SettingFragment());
//
//                        return true;
//                }
//                return true;
//            }
//        });



    }    // end of OnCreate()


    @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(actionBarDrawerToggle.onOptionsItemSelected(item)){


        int id = item.getItemId();
        switch (id){
            case R.id.notes:
                Toast.makeText(MainActivity.this, "I am note2 ", Toast.LENGTH_SHORT).show();
                replaceFragment(new NoteFragment());

                return true;
            case R.id.setting:
                replaceFragment(new SettingFragment());

        }
                return  true;
            }
            return super.onOptionsItemSelected(item);
        }


    public void replaceFragment(Fragment fragment) {
        this.fragment = fragment;
        //fragmentName = fragment.getClass().getSimpleName();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame_layout,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
//        if(id==R.id.notes){
//            Toast.makeText(this, "Note", Toast.LENGTH_SHORT).show();
//
//        } else if (id==R.id.setting) {
//            Toast.makeText(this, "Note", Toast.LENGTH_SHORT).show();
//
//        }


    }
}