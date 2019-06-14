package com.example.dars_17_advanced_rv.adapter.vh

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dars_17_advanced_rv.common.toast
import com.example.dars_17_advanced_rv.model.NameModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_name.*


class NameVH(override val containerView: View)
    : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private lateinit var name: String

    init {
        containerView.setOnClickListener {
            if (::name.isInitialized)
                containerView.context.toast(name)
        }
    }

    fun onBind(model: NameModel) {
        name = model.name
        tv.text = model.name
    }
}