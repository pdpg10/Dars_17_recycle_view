package com.example.dars_17_advanced_rv.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dars_17_advanced_rv.R;
import com.example.dars_17_advanced_rv.common.Constants;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String name = getIntent().getStringExtra(Constants.KEY_NAME);
        TextView tv = findViewById(R.id.textView);
        tv.setText(name);
    }
}
