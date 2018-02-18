package com.rasco.myapp.myapplication.base;

/**
 * Created by Admin on 2/15/2018.
 */

public class Colors {

    private int _id;
    private String name;
    private String colorOne;
    private String ColorTwo;
    private String colorThree;

    public Colors() {
    }

    public Colors(String name) {
    }

    public Colors(int _id, String name, String colorOne, String colorTwo, String colorThree) {
        this._id = _id;
        this.name = name;
        this.colorOne = colorOne;
        ColorTwo = colorTwo;
        this.colorThree = colorThree;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorOne() {
        return colorOne;
    }

    public void setColorOne(String colorOne) {
        this.colorOne = colorOne;
    }

    public String getColorTwo() {
        return ColorTwo;
    }

    public void setColorTwo(String colorTwo) {
        ColorTwo = colorTwo;
    }

    public String getColorThree() {
        return colorThree;
    }

    public void setColorThree(String colorThree) {
        this.colorThree = colorThree;
    }
}
