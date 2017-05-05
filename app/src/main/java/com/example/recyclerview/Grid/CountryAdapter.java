package com.example.recyclerview.Grid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerview.Country;
import com.example.recyclerview.R;

import java.util.List;

/**
 * Created by SEVAK on 06.05.2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    private List<Country> countries;
    private CountryViewHolder.CountryItemClickListener clickListener;

    public CountryAdapter(List<Country> countries, CountryViewHolder.CountryItemClickListener clickListener) {
        this.countries = countries;
        this.clickListener = clickListener;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_country_grid, parent, false);
        return new CountryViewHolder(view, clickListener);
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
