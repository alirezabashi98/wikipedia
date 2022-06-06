package com.example.wikipedia.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wikipedia.adapter.ExploreAdapter
import com.example.wikipedia.databinding.FragmentExploreBinding
import com.example.wikipedia.model.ItemPostModel
import com.example.wikipedia.utility.getDataItemPost

class ExploreFragment : Fragment() {

    private lateinit var binding: FragmentExploreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExploreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireContext().setRecyclerExplore()
    }

    private fun Context.setRecyclerExplore() {
        binding.recyclerExplore.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val list = getDataItemPost().filter { itemPostModel -> !itemPostModel.isTrend }

        binding.recyclerExplore.adapter = ExploreAdapter(list as ArrayList<ItemPostModel>)
    }

}