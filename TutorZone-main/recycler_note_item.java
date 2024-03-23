package com.example.myapplication;

import android.widget.ImageButton;

public class recycler_note_item {
    String access;
    String contact;
    ImageButton arrow;
    boolean visibility;

    public recycler_note_item(String access, String contact, ImageButton arrow) {
        this.access = access;
        this.contact = contact;
        this.arrow = arrow;
        this.visibility=false;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
