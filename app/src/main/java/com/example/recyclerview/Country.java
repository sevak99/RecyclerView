package com.example.recyclerview;

import java.io.Serializable;

/**
 * Created by SEVAK on 03.05.2017.
 */

public class Country implements Serializable {

    private String code;
    private String name;
    private boolean isSelected;
    private int list_flagID;
    private int grid_flagID;

    public Country(String code, String name, boolean isSelected) {
        this.code = code;
        this.name = name;
        this.isSelected = isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setList_flagID(int list_flagID) {
        this.list_flagID = list_flagID;
    }

    public void setGrid_flagID(int grid_flagID) {
        this.grid_flagID = grid_flagID;
    }


    public int getList_flagID() {
        return list_flagID;
    }

    public int getGrid_flagID() {
        return grid_flagID;
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
