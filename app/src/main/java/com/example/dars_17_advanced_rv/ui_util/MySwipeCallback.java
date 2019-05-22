package com.example.dars_17_advanced_rv.ui_util;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.adapter.NameAdapter;
import com.google.android.material.snackbar.Snackbar;

public class MySwipeCallback extends ItemTouchHelper.SimpleCallback {
    private NameAdapter adapter;

    public MySwipeCallback(NameAdapter adapter) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int pos = viewHolder.getAdapterPosition();
        adapter.removeItemByPosition(pos);
        showSnackBar(viewHolder.itemView);
    }

    private void showSnackBar(View rootView) {
        Snackbar snackbar = Snackbar.make(rootView, "Undo item", Snackbar.LENGTH_SHORT);
        snackbar.setAction("undo", v -> adapter.undoLastRemovedItem());
        snackbar.show();
    }

}
