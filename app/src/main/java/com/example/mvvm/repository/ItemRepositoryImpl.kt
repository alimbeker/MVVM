package com.example.mvvm.repository

class ItemRepositoryImpl : ItemRepository {
    private var itemList: List<Item> = listOf()

    override fun getItemList(): List<Item> {
        return itemList.ifEmpty { getRemoteFaq() }
    }

    private fun getRemoteFaq(): List<Item> {
        val list: MutableList<Item> = mutableListOf(
            Item(1,"Groceries"),
            Item(2,"Training"),
            Item(3,"Homework")
        )

        itemList = list

        return list
    }
}