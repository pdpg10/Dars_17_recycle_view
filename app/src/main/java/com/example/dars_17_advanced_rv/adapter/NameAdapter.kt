package com.example.dars_17_advanced_rv.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dars_17_advanced_rv.R
import com.example.dars_17_advanced_rv.adapter.vh.NameVH
import com.example.dars_17_advanced_rv.common.inflate
import com.example.dars_17_advanced_rv.model.NameModel

class NameAdapter(
        context: Context,
        private val nameList: MutableList<NameModel>
) : RecyclerView.Adapter<NameVH>() {
    private val inflater: LayoutInflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): NameVH {
        val v = parent.inflate(inflater, R.layout.item_name)
        return NameVH(v)
    }

    override fun getItemCount() = nameList.size

    override fun onBindViewHolder(holder: NameVH,
                                  position: Int) {
        val model = nameList[position]
        holder.onBind(model)
    }

}