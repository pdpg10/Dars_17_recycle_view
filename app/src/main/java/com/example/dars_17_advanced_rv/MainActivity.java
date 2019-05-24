package com.example.dars_17_advanced_rv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.adapter.NameAdapter;
import com.example.dars_17_advanced_rv.common.Constants;
import com.example.dars_17_advanced_rv.model.NameModel;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.ScaleInTopAnimator;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private SearchView searchView;
    private NameAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpData();
        setUpSearchView();
    }

    private void setUpSearchView() {
        searchView = findViewById(R.id.et);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.searchWith(newText);
                return true;
            }
        });
    }

    private void setUpData() {
        rv = findViewById(R.id.rv);
        rv.setItemAnimator(new DefaultItemAnimator());

        ScaleInTopAnimator scaleInTopAnimator = new ScaleInTopAnimator();
        scaleInTopAnimator.setAddDuration(500);
        scaleInTopAnimator.setRemoveDuration(500);
        rv.setItemAnimator(scaleInTopAnimator);

        ArrayList<NameModel> list = genData();
        adapter = new NameAdapter(this, list);
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
}
