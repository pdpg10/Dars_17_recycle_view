package com.example.dars_17_advanced_rv.adapter.vh;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.dars_17_advanced_rv.R;
import com.example.dars_17_advanced_rv.model.SweetModel;

public class SweetVH extends BaseVH<SweetModel> {
    private TextView tv;

    public SweetVH(@NonNull View view) {
        super(view);
        tv = view.findViewById(R.id.tv);
    }

    public void onBind(SweetModel model) {
        tv.setText(model.getTitle());
    }
}


