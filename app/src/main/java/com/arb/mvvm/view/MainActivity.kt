package com.arb.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.arb.mvvm.R
import com.arb.mvvm.dataClass.MyDataClass
import com.arb.mvvm.databinding.ActivityMainBinding
import com.arb.mvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() , MainViewModel.MainViewModelCallback {

    lateinit var binding : ActivityMainBinding
    lateinit var myAdapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.vm = MainViewModel(this)

        myAdapter = MyAdapter(listOf())
        binding.recyclerViewMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL ,false)
            adapter = myAdapter
        }

    }

    override fun onDataFetched(users: List<MyDataClass>) {

        myAdapter.reloadData(users)

    }

}