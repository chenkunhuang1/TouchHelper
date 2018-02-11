package com.example.itemtouchhelperdemo;

/**
 * Created by Administrator on 2018/2/11 0011.
 */

public class ItemEntity {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    private boolean isChecked;
}
