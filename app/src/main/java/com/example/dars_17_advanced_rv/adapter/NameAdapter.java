package com.example.dars_17_advanced_rv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

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
    private int lastScrollPos = 0;
    private IFilter filter;
    private ArrayList<NameModel> originList;
    private Animation animToBottom, animToTop;


    public NameAdapter(Context context,
                       ArrayList<NameModel> names) {
        this.names = names;
        originList = (ArrayList<NameModel>) names.clone();
        this.inflater = LayoutInflater.from(context);
        filter = new FilterImpl(names);
    }

    private void loadAnimation(Context context) {
        animToTop = AnimationUtils.loadAnimation(context, R.anim.up_from_bottom);
        animToBottom = AnimationUtils.loadAnimation(context, R.anim.down_from_top);
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
        //todo if want use scroll anim un comment
//        loadAnimation(holder.itemView.getContext());
//        if (position > lastScrollPos) {
//            holder.itemView.startAnimation(animToTop);
//        } else {
//            holder.itemView.startAnimation(animToBottom);
//        }
        lastScrollPos = position;
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public void searchWith(String newText) {
        filter.search(newText);
        NameCallBack callback = new NameCallBack(originList, names);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        result.dispatchUpdatesTo(this);
//        notifyDataSetChanged();
    }
}
