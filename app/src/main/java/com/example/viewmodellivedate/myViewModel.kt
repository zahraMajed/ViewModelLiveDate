package com.example.viewmodellivedate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//step 3: create custom viewModel class
//it is class that designed to store and manage ui related data in a cycle conscious way

// 1) should extend ViewModel() class
class myViewModel : ViewModel(){

    var number =0

    //2) create live data and initialize it by lazy initializer
    //we gonna use it to notify the program that something has changed and it'll updated automatically for us
    val currentNumber: MutableLiveData<Int> by lazy {
        //every time we refer to this it will create a mutable live data object
        //and that will be used to store a number and update it
        MutableLiveData<Int>()
    }

    val currentBoolean: MutableLiveData<Boolean> by lazy {
        //every time we refer to this it will create a mutable live data object
        //and that will be used to store a number and update it
        MutableLiveData<Boolean>()
    }



}