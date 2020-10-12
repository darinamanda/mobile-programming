package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.model.Powerpuff
import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.model.powerpuffDb

class ListViewModel : ViewModel() {
    val powerpuffs = MutableLiveData<List<Powerpuff>>()
    val error = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refesh() {

        val powerpuffList: ArrayList<Powerpuff> = powerpuffDb

        powerpuffs.value = powerpuffList
        error.value = false
        loading.value = false
    }
}