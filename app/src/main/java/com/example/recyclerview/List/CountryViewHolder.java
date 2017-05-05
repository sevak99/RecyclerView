package com.example.recyclerview.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.Country;
import com.example.recyclerview.R;

import static com.example.recyclerview.R.drawable.flag_unknown;

/**
 * Created by SEVAK on 03.05.2017.
 */

public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ImageView flag;
    private TextView countryName;
    private CheckBox isChecked;
    private Country country;
    private View listItem;

    private CountryItemClickListener countryItemClickListener;


    public CountryViewHolder(View itemView, CountryItemClickListener countryItemClickListener) {
        super(itemView);

        listItem = itemView.findViewById(R.id.my_list_item);
        flag = (ImageView) itemView.findViewById(R.id.country_flag_iv);
        countryName = (TextView) itemView.findViewById(R.id.country_name);
        isChecked = (CheckBox) itemView.findViewById(R.id.isChecked);
        isChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                country.setSelected(isChecked);
            }
        });
        listItem.setOnClickListener(this);

        this.countryItemClickListener = countryItemClickListener;
    }

    public void bind(final Country country) {

        this.country = country;
        countryName.setText(country.getName());
        isChecked.setChecked(country.isSelected());

        int resourceId = country.getFlagID();
        if (resourceId > 0) {
            flag.setImageResource(resourceId);
        } else {
            flag.setImageResource(flag_unknown);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_list_item:
                notifyCountryItemClicked();
                break;
        }
    }

    private void notifyCountryItemClicked() {
        if(countryItemClickListener != null) {
            countryItemClickListener.onCountryItemClick(country);
        }
    }

    public interface CountryItemClickListener {
        void onCountryItemClick(Country country);
    }
}
