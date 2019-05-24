package com.example.dars_17_advanced_rv.adapter.search;

import com.example.dars_17_advanced_rv.model.NameModel;

import java.util.ArrayList;

public class FilterImpl implements IFilter {
    private ArrayList<NameModel> originList;
    private ArrayList<NameModel> tempList;

    public FilterImpl(ArrayList<NameModel> tempList) {
        originList = (ArrayList<NameModel>) tempList.clone();
        this.tempList = tempList;
    }

    @Override
    public void search(String text) {
        tempList.clear();
        if (text.isEmpty()) {
            tempList.addAll(originList);
        } else {
            for (NameModel model : originList) {
                if (model.getName().toLowerCase().contains(text.toLowerCase())) {
                    tempList.add(model);
                }
            }
        }
    }
}
