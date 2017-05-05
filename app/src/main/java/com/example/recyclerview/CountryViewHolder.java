package com.example.recyclerview;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.recyclerview.R.drawable.flag_transparent;
import static com.example.recyclerview.R.drawable.flag_unknown;

/**
 * Created by SEVAK on 03.05.2017.
 */

public class CountryViewHolder extends RecyclerView.ViewHolder {

    ImageView flag;
    TextView countryName;
    CheckBox isChecked;
    Country myCountry;

    private int listOrGrid;

    public CountryViewHolder(View itemView, int listOrGrid) {
        super(itemView);

        flag = (ImageView) itemView.findViewById(R.id.country_flag_iv);
        countryName = (TextView) itemView.findViewById(R.id.country_name);
        isChecked = (CheckBox) itemView.findViewById(R.id.isChecked);

        isChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                myCountry.setSelected(isChecked);
            }
        });

        this.listOrGrid = listOrGrid;
    }

    public void bind(final Country country) {

        myCountry = country;

        countryName.setText(country.getName());
        isChecked.setChecked(country.isSelected());


        int resourceId;
        switch (listOrGrid) {
            case CountryAdapter.LIST_NUMBER:
                resourceId = country.getList_flagID();
                if (resourceId > 0) {
                    flag.setImageResource(resourceId);
                } else {
                    flag.setImageResource(flag_unknown);
                }
                break;
            case CountryAdapter.GRID_NUMBER:
                resourceId = country.getGrid_flagID();
                if (resourceId > 0) {
                    flag.setImageResource(resourceId);
                } else {
                    flag.setImageResource(flag_unknown);
                }
                break;
        }
    }
}
