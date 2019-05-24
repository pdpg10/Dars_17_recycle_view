package com.example.dars_17_advanced_rv.adapter.callback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.dars_17_advanced_rv.model.NameModel;

public class NameItemCallBack extends DiffUtil.ItemCallback<NameModel> {

    @Override
    public boolean areItemsTheSame(@NonNull NameModel oldItem,
                                   @NonNull NameModel newItem) {
        return oldItem.equals(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull NameModel oldItem,
                                      @NonNull NameModel newItem) {
        return oldItem.getName().equals(newItem.getName());
    }
}
