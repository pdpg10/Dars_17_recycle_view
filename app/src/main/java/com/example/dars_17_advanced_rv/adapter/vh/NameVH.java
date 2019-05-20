package com.example.dars_17_advanced_rv.adapter.vh;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.R;
import com.example.dars_17_advanced_rv.common.ItemClickListener;
import com.example.dars_17_advanced_rv.model.NameModel;

public class NameVH extends
        RecyclerView.ViewHolder
        implements View.OnClickListener {
    private TextView tv;
    private ItemClickListener listener;
    private NameModel model;

    public NameVH(@NonNull View view) {
        super(view);
        this.listener = (ItemClickListener) view.getContext();
        tv = view.findViewById(R.id.tv);
        view.setOnClickListener(this);
    }

    public void onBind(NameModel model) {
        this.model = model;
        tv.setText(model.getName());
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(model);
    }
}


