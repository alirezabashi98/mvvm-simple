package com.arb.mvvm.model

import android.os.Handler
import androidx.databinding.ObservableField
import com.arb.mvvm.dataClass.MyDataClass

class MainModel {

    fun getData(mainModelCallback: MainModelCallback){

        Handler().postDelayed({

            val data = listOf(
                MyDataClass("alireza","bashi"),
                MyDataClass("mmd","goli"),
                MyDataClass("vhid","shty"),
                MyDataClass("ali","lndy"),
                MyDataClass("mmd","bgi"),
                MyDataClass("mmd","mmdy")
            )
            mainModelCallback.onDataFetched(data)

        },4000)

    }

    interface MainModelCallback{

        fun onDataFetched(users:List<MyDataClass>)

    }

}