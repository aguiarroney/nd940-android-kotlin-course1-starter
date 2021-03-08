package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeFragmentViewModel: ViewModel() {

    private var _shoeList: MutableLiveData<List<Shoe>> = MutableLiveData()
    val shoeList: LiveData<List<Shoe>> = _shoeList

    val teste: MutableLiveData<String> = MutableLiveData()

    fun setTeste(s:String){
        teste.value = s
    }

    fun addShoe(){
        
    }
}