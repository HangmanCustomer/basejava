package ru.javawebinar.basejava.model;

import java.util.ArrayList;

public class ListSection extends Sections {
    private ArrayList<String> info;

    public ListSection(ArrayList<String> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        String mids = "\n";
        for (int i = 0; i < info.size(); i++) {
            mids = mids + info.get(i);
            if (i == info.size() - 1) {
                break;
            }
            mids = mids + "\n";
        }
        return mids;
    }
}
