package com.android.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectContacts extends AppCompatActivity {
    ActionBar actionBar;
    ListView contactsListView;
    ContactsAdapter contactsAdapter;

//    ArrayList<Contact>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contacts);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(getString(R.string.action_bar_color))));
        this.setTitle(R.string.choose_contacts_in_actionbar);


    }
}