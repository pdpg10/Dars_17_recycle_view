package com.example.dars_17_advanced_rv.adapter.search;

import com.example.dars_17_advanced_rv.model.NameModel;

import java.util.ArrayList;

public interface IFilter {
    ArrayList<NameModel> search(String text);
}
