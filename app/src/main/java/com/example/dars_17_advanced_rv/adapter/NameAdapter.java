package com.example.dars_17_advanced_rv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.R;
import com.example.dars_17_advanced_rv.adapter.callback.NameCallBack;
import com.example.dars_17_advanced_rv.adapter.search.FilterImpl;
import com.example.dars_17_advanced_rv.adapter.search.IFilter;
import com.example.dars_17_advanced_rv.adapter.vh.NameVH;
import com.example.dars_17_advanced_rv.model.NameModel;

import java.util.ArrayList;

public class NameAdapter
        extends RecyclerView.Adapter<NameVH> {
    private ArrayList<NameModel> names;
    private LayoutInflater inflater;
    private IFilter filter;


    public NameAdapter(Context context,
                       ArrayList<NameModel> names) {
        this.names = names;
        this.inflater = LayoutInflater.from(context);
        filter = new FilterImpl(names);
    }


    @NonNull
    @Override
    public NameVH onCreateViewHolder(@NonNull ViewGroup parent,
                                     int viewType) {
        View view = inflater.inflate(R.layout.item_name, parent, false);
        return new NameVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameVH holder,
                                 int position) {
        NameModel model = names.get(position);
        holder.onBind(model);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public void searchWith(String newText) {
        ArrayList<NameModel> newList = filter.search(newText);
        NameCallBack callback = new NameCallBack(names, newList);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        names.clear();
        names.addAll(newList);
        result.dispatchUpdatesTo(this);
    }
}
