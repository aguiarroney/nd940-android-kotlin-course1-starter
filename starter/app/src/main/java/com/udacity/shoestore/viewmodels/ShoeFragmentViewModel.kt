package com.udacity.shoestore.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeFragmentViewModel: ViewModel() {

    private val _shoeControllList = mutableListOf<Shoe>()
    val shoeList: MutableLiveData<List<Shoe>> = MutableLiveData()

    fun addShoe(mName: String, mSize: Double, mCompany: String, mDesc: String){
        val mShoe = Shoe(mName, mSize, mCompany, mDesc, emptyList())
        _shoeControllList.add(mShoe)
        shoeList.value = _shoeControllList
    }
}