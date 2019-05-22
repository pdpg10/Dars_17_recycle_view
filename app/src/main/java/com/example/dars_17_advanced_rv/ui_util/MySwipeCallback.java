package com.example.dars_17_advanced_rv.ui_util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dars_17_advanced_rv.adapter.NameAdapter;
import com.google.android.material.snackbar.Snackbar;

public class MySwipeCallback extends ItemTouchHelper.SimpleCallback {
    private NameAdapter adapter;
    private Drawable icon;
    private Drawable background;

    public MySwipeCallback(NameAdapter adapter,
                           Drawable icon) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.adapter = adapter;
        this.background = new ColorDrawable(Color.RED);
        this.icon = icon;
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

    @Override
    public void onChildDraw(@NonNull Canvas c,
                            @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder,
                            float dX,
                            float dY,
                            int actionState,
                            boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        View currentView = viewHolder.itemView;
        int iconMargin = (currentView.getHeight() - icon.getIntrinsicHeight()) / 2;
        int iconTop = currentView.getTop() + iconMargin;
        int iconBottom = iconTop + icon.getIntrinsicHeight();

        if (dX > 0) {//swipe to right
            int iconLeft = currentView.getLeft() + iconMargin;
            int iconRight = iconLeft + icon.getIntrinsicWidth();
            icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
            background.setBounds(currentView.getLeft(), currentView.getTop(), currentView.getLeft() + (int) dX, currentView.getBottom());
        } else if (dX < 0) {//swipe to left

        } else {
            icon.setBounds(0, 0, 0, 0);
            background.setBounds(0, 0, 0, 0);
        }
        background.draw(c);
        icon.draw(c);
    }
}
