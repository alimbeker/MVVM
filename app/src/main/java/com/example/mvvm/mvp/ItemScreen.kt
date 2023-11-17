package com.example.mvvm.mvp

import com.example.mvvm.repository.Item

interface ItemScreen {
        interface View {
            fun showMessage(message: String)
            fun showData(list: List<Item>)
        }

        interface Presenter {
            fun getData()
            fun openDetails(item: Item)
        }
    }
