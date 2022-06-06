package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wikipedia.databinding.ItemSkillsBinding
import com.example.wikipedia.model.SkillsModel

class SkillsAdapter(private val data: ArrayList<SkillsModel>) :
    RecyclerView.Adapter<SkillsAdapter.ViewHolderTrend>() {

    inner class ViewHolderTrend(
        private var itemSkillsView: ItemSkillsBinding
    ) : RecyclerView.ViewHolder(itemSkillsView.root) {

        fun setView(itemPost: SkillsModel) {
            itemSkillsView.imgSkillsMain.setImageResource(itemPost.icon)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTrend =
        ViewHolderTrend(
            ItemSkillsBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )

    override fun onBindViewHolder(holder: ViewHolderTrend, position: Int) =
        holder.setView(data[position])

    override fun getItemCount(): Int = data.size

}