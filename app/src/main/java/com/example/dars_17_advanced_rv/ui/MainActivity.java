package com.example.dars_17_advanced_rv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.R;
import com.example.dars_17_advanced_rv.adapter.NameAdapter;
import com.example.dars_17_advanced_rv.common.Constants;
import com.example.dars_17_advanced_rv.common.ItemClickListener;
import com.example.dars_17_advanced_rv.model.NameModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rv;
    private NameAdapter adapter;
    private ItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_add)
                .setOnClickListener(this);
        setUpItemClickListener();
        setUpData();
    }

    private void setUpItemClickListener() {
        listener = new ItemClickListener() {
            @Override
            public void onItemClick(NameModel model) {
                openNextActivity(model);
            }
        };
    }

    private void openNextActivity(NameModel model) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Constants.KEY_NAME, model.getName());
        startActivity(intent);
    }

    private void setUpData() {
        rv = findViewById(R.id.rv);
        ArrayList<NameModel> list = genData();
        adapter = new NameAdapter(this, list, listener);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
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

    @Override
    public void onClick(View v) {
        adapter.addItem();
        rv.scrollToPosition(0);
    }
}
