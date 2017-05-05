package com.example.recyclerview.Grid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.recyclerview.Activities.MainActivity;
import com.example.recyclerview.Country;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private static ArrayList<Country> countries;
    private CountryViewHolder.CountryItemClickListener clickListener;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        recyclerView = (RecyclerView) findViewById(R.id.grid_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));

        countries = (ArrayList<Country>) getIntent().getSerializableExtra(MainActivity.KEY_TITLE);
        for(int i = 0; i < countries.size(); i++) {
            int resourceId = getResources().getIdentifier("flag_" + countries.get(i).getCountryCode(), "drawable", getPackageName());
            countries.get(i).setFlagID(resourceId);
        }

        clickListener = new CountryViewHolder.CountryItemClickListener() {
            @Override
            public void onCountryItemClick(Country country) {
                Toast.makeText(context, country.getName(), Toast.LENGTH_LONG).show();
            }
        };

        adapter = new CountryAdapter(countries, clickListener);
        recyclerView.setAdapter(adapter);
    }
}
