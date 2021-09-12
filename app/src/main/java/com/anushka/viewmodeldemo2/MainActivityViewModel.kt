package com.anushka.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    /**
     * - LiveData is an aware observable data holder class
     * - It updates observers in a active lifecycle state : it automatically updates UI when app data changes
     * - No need to write codes to handle lifecycle manually
     * - We can share our app's services between different components of the app
     *
     * MutableLiveData is a subclass of LiveData allowing any data changes / updates
     */
    private var total = MutableLiveData<Int>()

    /**
     * For good coding practice we will encapsulate 'total'.
     * We declare a val of LiveData type (read-only) to be accessible through a 'get'
     */
    val totalData: LiveData<Int>
        get() = total

    init {
        total.value = startingTotal
    }

    fun setTotal(input: Int) {
        total.value = (total.value)?.plus(input)
    }
}