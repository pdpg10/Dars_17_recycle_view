package com.example.dars_17_advanced_rv.common

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes

fun Context.toast(msg: String?) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun ViewGroup.inflate(inflater: LayoutInflater,
                      @LayoutRes layoutResId: Int) =
        inflater.inflate(layoutResId, this, false)
