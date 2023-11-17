package com.example.mvvm.repository

interface ItemRepository {
    fun getItemList(): List<Item>
}