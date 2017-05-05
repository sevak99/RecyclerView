package com.example.recyclerview;

import java.io.Serializable;

/**
 * Created by SEVAK on 03.05.2017.
 */

public class Country implements Serializable {

    private String code;
    private String name;
    private boolean isSelected;
    private int flagID;

    public Country(String code, String name, boolean isSelected) {
        this.code = code;
        this.name = name;
        this.isSelected = isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setFlagID(int flagID) {
        this.flagID = flagID;
    }


    public int getFlagID() {
        return flagID;
    }

    public String getCountryCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
