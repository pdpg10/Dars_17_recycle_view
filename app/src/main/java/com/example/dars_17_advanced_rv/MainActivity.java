package com.example.dars_17_advanced_rv;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.adapter.NameAdapter;
import com.example.dars_17_advanced_rv.common.Constants;
import com.example.dars_17_advanced_rv.model.NameModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private SharedPreferences preferences;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        setUpData();
    }

    private void setUpData() {
        rv = findViewById(R.id.rv);
        ArrayList<NameModel> list = genData();
        NameAdapter adapter = new NameAdapter(this, list);
        linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

        loadRvScrollState();
    }

    private void loadRvScrollState() {
//        int pos = preferences.getInt(Constants.SCROLL_STATE, 0);
//        rv.scrollToPosition(pos);
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
    protected void onSaveInstanceState(Bundle outState) {
        Parcelable state = linearLayoutManager.onSaveInstanceState();
        outState.putParcelable("state", state);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Parcelable state = savedInstanceState.getParcelable("state");
        linearLayoutManager.onRestoreInstanceState(state);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        int lastScrollPos = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
//        preferences.edit().putInt(Constants.SCROLL_STATE, lastScrollPos).apply();
    }
}
