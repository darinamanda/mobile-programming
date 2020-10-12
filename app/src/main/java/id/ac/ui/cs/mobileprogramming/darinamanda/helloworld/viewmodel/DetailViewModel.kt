package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.model.Powerpuff
import id.ac.ui.cs.mobileprogramming.darinamanda.helloworld.model.powerpuffDb


class DetailViewModel : ViewModel() {
    val powerpuff = MutableLiveData<Powerpuff>()

    fun fetch(powerpuffIndex: Int) {
        powerpuff.value = powerpuffDb[powerpuffIndex]
    }

}