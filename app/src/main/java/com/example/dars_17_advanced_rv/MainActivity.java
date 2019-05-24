package com.example.dars_17_advanced_rv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.adapter.NameAdapter;
import com.example.dars_17_advanced_rv.common.Constants;
import com.example.dars_17_advanced_rv.model.NameModel;

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
        ArrayList<NameModel> list = genData();
        NameAdapter adapter = new NameAdapter(this, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

//        SnapHelper snapHelper = new LinearSnapHelper();
//        snapHelper.attachToRecyclerView(rv);
    }

    private ArrayList<NameModel> genData() {

        ArrayList<NameModel> list = new ArrayList<>(Constants.NAMES.length);
        NameModel model;
        for (String name : Constants.NAMES) {
            model = new NameModel(name);
            list.add(model);
        }
        return list;
    }
}
