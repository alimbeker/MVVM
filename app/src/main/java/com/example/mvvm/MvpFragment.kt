package com.example.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.databinding.FragmentMvpBinding
import com.example.mvvm.mvp.ItemPresenter
import com.example.mvvm.mvp.ItemScreen
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

        binding.listView.layoutManager = LinearLayoutManager(requireContext())
        binding.listView.adapter = adapter

        adapter.itemClick = {
            presenter.openDetails(it)

        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showData(list: List<Item>) {
        adapter.submitList(list)
    }
}