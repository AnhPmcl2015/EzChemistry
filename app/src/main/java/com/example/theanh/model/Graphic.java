package com.example.theanh.model;

/**
 * Created by THE ANH on 11/23/2017.
 */

public class Graphic {
    private String idGraphic;
    private byte[] image;
    private byte[] icon;
    private String idBackgroundColor;
    private String idTextColor;

    public Graphic(String idGraphic, byte[] image, byte[] icon, String idBackgroundColor, String idTextColor) {
        this.idGraphic = idGraphic;
        this.image = image;
        this.icon = icon;
        this.idBackgroundColor = idBackgroundColor;
        this.idTextColor = idTextColor;
    }

    public Graphic() {
    }

    public String getIdGraphic() {
        return idGraphic;
    }

    public void setIdGraphic(String idGraphic) {
        this.idGraphic = idGraphic;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getIdBackgroundColor() {
        return idBackgroundColor;
    }

    public void setIdBackgroundColor(String idBackgroundColor) {
        this.idBackgroundColor = idBackgroundColor;
    }

    public String getIdTextColor() {
        return idTextColor;
    }

    public void setIdTextColor(String idTextColor) {
        this.idTextColor = idTextColor;
    }
}
