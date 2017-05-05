package com.example.recyclerview.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview.Country;
import com.example.recyclerview.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_TITLE = "com.example.recyclerview.Activities.MainActivity.title";
    private static final String FILE_NAME  = "countries.csv";

    private Button list;
    private Button grid;
    private static ArrayList<Country> countries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (Button) findViewById(R.id.list);
        grid = (Button) findViewById(R.id.grid);
        list.setOnClickListener(this);
        grid.setOnClickListener(this);

        countries = new ArrayList<>();
        readFile();

        for(int i = 0; i < countries.size(); i++) {
            int resourceId = getResources().getIdentifier("flag_" + countries.get(i).getCountryCode(), "drawable", getPackageName());
            countries.get(i).setGrid_flagID(resourceId);
            resourceId = getResources().getIdentifier("s_flag_" + countries.get(i).getCountryCode(), "drawable", getPackageName());
            countries.get(i).setList_flagID(resourceId);
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.list:
                intent = new Intent(this, ListActivity.class);
                intent.putExtra(KEY_TITLE, countries);
                startActivity(intent);
                break;
            case R.id.grid:
                intent = new Intent(this, GridActivity.class);
                intent.putExtra(KEY_TITLE, countries);
                startActivity(intent);
                break;
        }
    }

    private void readFile() {
        try {
            InputStream inputStream = getAssets().open(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String string;
            while ((string = reader.readLine()) != null) {
                String[] strings = string.split(",");
                countries.add(new Country(strings[0].toLowerCase(), strings[1], false));
            }

            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
