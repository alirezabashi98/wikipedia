package com.example.wikipedia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wikipedia.databinding.ItemExploreBinding
import com.example.wikipedia.model.ItemPostModel
import com.example.wikipedia.utility.glideLoadImageUrl

class ExploreAdapter(private val data: ArrayList<ItemPostModel>) :
    RecyclerView.Adapter<ExploreAdapter.ViewHolderExplore>() {

    inner class ViewHolderExplore(
        private var itemExploreView: ItemExploreBinding,
        var contxet: Context
    ) :
        RecyclerView.ViewHolder(itemExploreView.root) {

        fun setView(itemPost: ItemPostModel) {
            contxet.glideLoadImageUrl(itemPost.ImageUrl, itemExploreView.imgExploreMain)
            itemExploreView.txtExploreTitle.text = itemPost.Title
            itemExploreView.txtExploreSubtitle.text = itemPost.Subtitle
            itemExploreView.txtExploreDetail.text = itemPost.Detail
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderExplore =
        ViewHolderExplore(
            ItemExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            parent.context
        )

    override fun onBindViewHolder(holder: ViewHolderExplore, position: Int) =
        holder.setView(data[position])

    override fun getItemCount(): Int = data.size

}