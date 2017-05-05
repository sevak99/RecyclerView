package com.example.recyclerview.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.recyclerview.Country;
import com.example.recyclerview.CountryAdapter;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private static ArrayList<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        countries = (ArrayList<Country>) getIntent().getSerializableExtra(MainActivity.KEY_TITLE);

        adapter = new CountryAdapter(countries, 1);
        recyclerView.setAdapter(adapter);

    }
}
