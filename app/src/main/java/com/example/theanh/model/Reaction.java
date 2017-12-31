package com.example.theanh.model;

public class Reaction {
    private String left;
    private String right;
    private String twoWayReaction;
    private String leftUsing, leftUsing1, leftUsing2, leftUsing3,leftUsing4,leftUsing5;

    public Reaction(String left, String right, String twoWayReaction, String leftUsing, String leftUsing1, String leftUsing2, String leftUsing3, String leftUsing4, String leftUsing5) {
        this.left = left;
        this.right = right;
        this.twoWayReaction = twoWayReaction;
        this.leftUsing = leftUsing;
        this.leftUsing1 = leftUsing1;
        this.leftUsing2 = leftUsing2;
        this.leftUsing3 = leftUsing3;
        this.leftUsing4 = leftUsing4;
        this.leftUsing5 = leftUsing5;
    }

    public Reaction(){

    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getTwoWayReaction() {
        return twoWayReaction;
    }

    public void setTwoWayReaction(String twoWayReaction) {
        this.twoWayReaction = twoWayReaction;
    }

    public String getLeftUsing() {
        return leftUsing;
    }

    public void setLeftUsing(String leftUsing) {
        this.leftUsing = leftUsing;
    }

    public String getLeftUsing1() {
        return leftUsing1;
    }

    public void setLeftUsing1(String leftUsing1) {
        this.leftUsing1 = leftUsing1;
    }

    public String getLeftUsing2() {
        return leftUsing2;
    }

    public void setLeftUsing2(String leftUsing2) {
        this.leftUsing2 = leftUsing2;
    }

    public String getLeftUsing3() {
        return leftUsing3;
    }

    public void setLeftUsing3(String leftUsing3) {
        this.leftUsing3 = leftUsing3;
    }

    public String getLeftUsing4() {
        return leftUsing4;
    }

    public void setLeftUsing4(String leftUsing4) {
        this.leftUsing4 = leftUsing4;
    }

    public String getLeftUsing5() {
        return leftUsing5;
    }

    public void setLeftUsing5(String leftUsing5) {
        this.leftUsing5 = leftUsing5;
    }
}
