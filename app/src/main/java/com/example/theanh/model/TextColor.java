package com.example.theanh.model;

/**
 * Created by THE ANH on 11/23/2017.
 */

public class TextColor {
    private String idTextColor;
    private String colorHex;
    private String name;

    public TextColor(String idTextColor, String colorHex, String name) {
        this.idTextColor = idTextColor;
        this.colorHex = colorHex;
        this.name = name;
    }

    public TextColor() {
    }

    public String getIdTextColor() {
        return idTextColor;
    }

    public void setIdTextColor(String idTextColor) {
        this.idTextColor = idTextColor;
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
