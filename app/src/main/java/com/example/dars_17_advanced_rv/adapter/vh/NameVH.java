package com.example.dars_17_advanced_rv.adapter.vh;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.R;
import com.example.dars_17_advanced_rv.model.NameModel;

public class NameVH extends RecyclerView.ViewHolder {
    private TextView tv;

    public NameVH(@NonNull View view) {
        super(view);
        tv = view.findViewById(R.id.tv);
    }

    public void onBind(NameModel model) {
        tv.setText(model.getName());
    }
}


