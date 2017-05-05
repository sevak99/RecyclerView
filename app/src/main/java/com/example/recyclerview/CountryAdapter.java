package com.example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by SEVAK on 03.05.2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    public static final int LIST_NUMBER = 1;
    public static final int GRID_NUMBER = 2;
    private List<Country> countries;
    private int listOrGrid;

    public CountryAdapter(List<Country> countries, int listOrGrid) {
        this.countries = countries;
        this.listOrGrid = listOrGrid;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (listOrGrid) {
            case LIST_NUMBER:
                view = inflater.inflate(R.layout.item_country, parent, false);
                return new CountryViewHolder(view, LIST_NUMBER);
            case GRID_NUMBER:
                view = inflater.inflate(R.layout.item_country_grid, parent, false);
                return new CountryViewHolder(view, GRID_NUMBER);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        holder.bind(countries.get(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
