package com.example.mvvm.moderviewvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.ItemAdapter
import com.example.mvvm.databinding.FragmentMvpBinding
import com.example.mvvm.repository.ItemRepositoryImpl


class FaqMvvmFragment : Fragment() {
    private lateinit var binding: FragmentMvpBinding
    private val adapter = ItemAdapter()
    private val viewModel = ItemViewModel(ItemRepositoryImpl())

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

        viewModel.getData()
        binding.listView.layoutManager = LinearLayoutManager(requireContext())
        binding.listView.adapter = adapter

//        adapter.itemClick = {
//        }

        viewModel.itemListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}