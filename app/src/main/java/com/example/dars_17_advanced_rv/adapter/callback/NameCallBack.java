package com.example.dars_17_advanced_rv.adapter.callback;

import androidx.recyclerview.widget.DiffUtil;

import com.example.dars_17_advanced_rv.model.NameModel;

import java.util.ArrayList;

public class NameCallBack extends DiffUtil.Callback {
    private ArrayList<NameModel> oldList;
    private ArrayList<NameModel> newList;

    public NameCallBack(ArrayList<NameModel> oldList,
                        ArrayList<NameModel> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

       @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        NameModel oldModel = oldList.get(oldItemPosition);
        NameModel newModel = newList.get(newItemPosition);
        return oldModel.equals(newModel);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        NameModel oldModel = oldList.get(oldItemPosition);
        NameModel newModel = newList.get(newItemPosition);
        return oldModel.getName().equals(newModel.getName());
    }
}
