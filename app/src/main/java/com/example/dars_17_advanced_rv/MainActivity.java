package com.example.dars_17_advanced_rv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.adapter.MyAdapter;
import com.example.dars_17_advanced_rv.common.Constants;
import com.example.dars_17_advanced_rv.model.BaseModel;
import com.example.dars_17_advanced_rv.model.NameModel;
import com.example.dars_17_advanced_rv.model.SweetModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpData();
    }

    private void setUpData() {
        rv = findViewById(R.id.rv);
        ArrayList<BaseModel> list = genData();
        MyAdapter adapter = new MyAdapter(this, list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    private ArrayList<BaseModel> genData() {
        ArrayList<BaseModel> list = new ArrayList<>(Constants.NAMES.length + Constants.NAMES.length / 5);
        NameModel model;
        SweetModel sweetModel;
        for (int i = 0; i < Constants.NAMES.length; i++) {
            model = new NameModel(Constants.NAMES[i]);
            list.add(model);
            if (i % 5 == 0) {
                sweetModel = new SweetModel("sweet-" + i);
                list.add(sweetModel);
            }
        }
        return list;
    }
}
