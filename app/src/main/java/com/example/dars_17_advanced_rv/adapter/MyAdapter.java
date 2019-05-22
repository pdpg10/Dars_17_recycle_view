package com.example.dars_17_advanced_rv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.R;
import com.example.dars_17_advanced_rv.adapter.vh.BaseVH;
import com.example.dars_17_advanced_rv.adapter.vh.NameVH;
import com.example.dars_17_advanced_rv.adapter.vh.SweetVH;
import com.example.dars_17_advanced_rv.model.BaseModel;
import com.example.dars_17_advanced_rv.model.NameModel;

import java.util.ArrayList;

public class MyAdapter
        extends RecyclerView.Adapter<BaseVH> {
    private final int NAME = 0;
    private final int SWEET = 1;
    private ArrayList<BaseModel> contentList;
    private LayoutInflater inflater;

    public MyAdapter(Context context,
                     ArrayList<BaseModel> contentList) {
        this.contentList = contentList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BaseVH onCreateViewHolder(@NonNull ViewGroup parent,
                                     int viewType) {
        if (viewType == NAME) {
            View view = inflater.inflate(R.layout.item_name, parent, false);
            return new NameVH(view);
        } else {
            View view = inflater.inflate(R.layout.item_sweet, parent, false);
            return new SweetVH(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        BaseModel model = contentList.get(position);
        if (model instanceof NameModel) return NAME;
        else return SWEET;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseVH holder,
                                 int position) {
        BaseModel model = contentList.get(position);
        holder.onBind(model);
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }
}
