package com.example.recyclerview.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerview.Country;
import com.example.recyclerview.CountryAdapter;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private static ArrayList<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        recyclerView = (RecyclerView) findViewById(R.id.grid_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));

        countries = (ArrayList<Country>) getIntent().getSerializableExtra(MainActivity.KEY_TITLE);

        adapter = new CountryAdapter(countries, 2);
        recyclerView.setAdapter(adapter);
    }
}
