package ru.javawebinar.basejava.model;

import java.util.ArrayList;

public class PlaceSection extends Sections {
    private ArrayList<Place> info;

    public PlaceSection(ArrayList<Place> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        String mids = "";
        for (int i = 0; i < info.size(); i++) {
            mids = mids + info.get(i);
            if (i == info.size() - 1) {
                break;
            }
        }
        return mids;
    }
}
