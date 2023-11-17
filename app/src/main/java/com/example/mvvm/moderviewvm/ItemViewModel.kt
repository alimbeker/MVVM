package com.example.mvvm.moderviewvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.repository.Item
import com.example.mvvm.repository.ItemRepository


class ItemViewModel(
    private var repository: ItemRepository
): ViewModel() {

    private var _itemListLiveData = MutableLiveData<List<Item>>()
    var itemListLiveData: LiveData<List<Item>> = _itemListLiveData

    fun getData() {
        val data = repository.getItemList()
        _itemListLiveData.postValue(data)
    }
}