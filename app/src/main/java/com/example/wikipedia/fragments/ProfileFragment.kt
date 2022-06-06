package com.example.wikipedia.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wikipedia.adapter.SkillsAdapter
import com.example.wikipedia.databinding.FragmentProfileBinding
import com.example.wikipedia.model.SkillsModel
import com.example.wikipedia.utility.getDataItemSkills

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().setRecyclerSkills()
    }

    private fun Context.setRecyclerSkills() {
        binding.recyclerSkills.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        val listSkills = getDataItemSkills()

        binding.recyclerSkills.adapter = SkillsAdapter(listSkills as ArrayList<SkillsModel>)
    }

}