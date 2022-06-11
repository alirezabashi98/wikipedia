package com.example.wikipedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.wikipedia.R
import com.example.wikipedia.databinding.FragmentPhotographBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class PhotographFragment : Fragment() {

    private lateinit var binding: FragmentPhotographBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotographBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireActivity()).load(R.drawable.img_photographer)
            .transform(RoundedCornersTransformation(32, 8))
            .into(binding.imgPhotographer)

    }


}