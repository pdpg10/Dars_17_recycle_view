package com.example.dars_17_advanced_rv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dars_17_advanced_rv.adapter.NameAdapter
import com.example.dars_17_advanced_rv.common.Commons
import com.example.dars_17_advanced_rv.model.NameModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpData()
    }

    private fun setUpData() {
        val nameList = genData()
        val nameAdapter = NameAdapter(this, nameList)
        rv.adapter = nameAdapter

    }

    private fun genData(): MutableList<NameModel> {
        val names = Commons.NAMES
        val nameList = mutableListOf<NameModel>()
        names.forEach { nameList += (NameModel(it)) }
        return nameList
    }
}