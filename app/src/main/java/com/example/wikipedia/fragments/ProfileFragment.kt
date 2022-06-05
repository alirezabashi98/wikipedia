package com.example.wikipedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wikipedia.R
import com.example.wikipedia.databinding.FragmentProfileBinding
import com.google.android.material.card.MaterialCardView

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
        val item = view.findViewById<MaterialCardView>(R.id.cardMain)
        item.setOnLongClickListener {
            item.isChecked =  !item.isChecked
            true
        }

    }

}