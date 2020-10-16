package com.arb.mvvm.viewModel

import androidx.databinding.ObservableField
import com.arb.mvvm.dataClass.MyDataClass
import com.arb.mvvm.model.MainModel

class MainViewModel(private val mainViewModelCallback: MainViewModelCallback) : MainModel.MainModelCallback {

    var isLoading = ObservableField(false)

    fun loadData() {

        val model = MainModel()
       isLoading.set(true)
        model.getData(this)

    }

    override fun onDataFetched(users: List<MyDataClass>) {
        mainViewModelCallback.onDataFetched(users)
        isLoading.set(false)
    }

    interface MainViewModelCallback{

        fun onDataFetched(users:List<MyDataClass>)

    }

}