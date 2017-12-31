package com.example.theanh.model;

/**
 * Created by THE ANH on 11/23/2017.
 */

public class BackgroundColor {
    private String idBackgroundColor;
    private String colorHex;
    private String name;

    public BackgroundColor(String idBackgroundColor, String colorHex, String name) {
        this.idBackgroundColor = idBackgroundColor;
        this.colorHex = colorHex;
        this.name = name;
    }

    public BackgroundColor() {
    }

    public String getIdBackgroundColor() {
        return idBackgroundColor;
    }

    public void setIdBackgroundColor(String idBackgroundColor) {
        this.idBackgroundColor = idBackgroundColor;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
