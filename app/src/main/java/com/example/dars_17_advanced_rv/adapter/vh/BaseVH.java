package com.example.dars_17_advanced_rv.adapter.vh;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseVH<T> extends RecyclerView.ViewHolder {
    public BaseVH(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void onBind(T model);
}
