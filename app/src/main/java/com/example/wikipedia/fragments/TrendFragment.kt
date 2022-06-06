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
import com.example.wikipedia.adapter.TrendAdapter
import com.example.wikipedia.databinding.FragmentTrendBinding
import com.example.wikipedia.model.ItemPostModel
import com.example.wikipedia.utility.getDataItemPost

class TrendFragment : Fragment() {

    private lateinit var binding: FragmentTrendBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrendBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().setRecyclerTrend()

    }

    private fun Context.setRecyclerTrend() {
        binding.recyclerTrend.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val listTrend = getDataItemPost().filter { itemPostModel -> itemPostModel.isTrend }

        binding.recyclerTrend.adapter = TrendAdapter(listTrend as ArrayList<ItemPostModel>)
    }

}