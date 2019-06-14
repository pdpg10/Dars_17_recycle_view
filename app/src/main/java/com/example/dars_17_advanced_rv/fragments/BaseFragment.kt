package com.example.dars_17_advanced_rv.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dars_17_advanced_rv.common.inflate

abstract class BaseFragment : Fragment() {
    abstract val layoutId: Int

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return container?.inflate(inflater, layoutId)
    }
}
