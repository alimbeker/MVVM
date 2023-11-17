package com.example.mvvm.mvp

import com.example.mvvm.repository.Item
import com.example.mvvm.repository.ItemRepository
import com.example.mvvm.repository.ItemRepositoryImpl

class ItemPresenter(
    private val view: ItemScreen.View
) : ItemScreen.Presenter {
    private val repository: ItemRepository = ItemRepositoryImpl()

    override fun getData() {
        val data = repository.getFaqList()
        view.showData(data)
    }

    override fun openDetails(item: Item) {
        view.showMessage(item.title)
    }
}