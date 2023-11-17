package com.example.mvvm.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.ItemAdapter
import com.example.mvvm.OffsetDecoration
import com.example.mvvm.databinding.FragmentMvpBinding
import com.example.mvvm.repository.Item


class FaqMvpFragment: Fragment(), ItemScreen.View {
    private lateinit var binding: FragmentMvpBinding
    private val adapter = ItemAdapter()
    private lateinit var presenter: ItemScreen.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMvpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ItemPresenter(this)
        presenter.getData()

        val listView = binding.listView

        listView.layoutManager = LinearLayoutManager(requireContext())
        listView.adapter = adapter

        adapter.itemClick = {
            presenter.openDetails(it)

        }


        val offsetDecoration = OffsetDecoration(start = 16, top = 16, end = 15, bottom = 16)
        listView.addItemDecoration(offsetDecoration)
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showData(list: List<Item>) {
        adapter.submitList(list)
    }
}