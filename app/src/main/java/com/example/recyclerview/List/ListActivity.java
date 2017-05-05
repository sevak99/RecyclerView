package com.example.recyclerview.List;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.recyclerview.Activities.MainActivity;
import com.example.recyclerview.Country;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private static ArrayList<Country> countries;
    private CountryViewHolder.CountryItemClickListener clickListener;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        countries = (ArrayList<Country>) getIntent().getSerializableExtra(MainActivity.KEY_TITLE);
        for(int i = 0; i < countries.size(); i++) {
            int resourceId = getResources().getIdentifier("s_flag_" + countries.get(i).getCountryCode(), "drawable", getPackageName());
            countries.get(i).setFlagID(resourceId);
        }
        clickListener = new CountryViewHolder.CountryItemClickListener() {
            @Override
            public void onCountryItemClick(Country country) {
                Toast.makeText(context, country.getName(), Toast.LENGTH_SHORT).show();
            }
        };

        adapter = new CountryAdapter(countries, clickListener);
        recyclerView.setAdapter(adapter);

    }
}
