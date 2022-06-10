package com.example.wikipedia.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.databinding.ItemTrendBinding
import com.example.wikipedia.model.ItemPostModel
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(
    private val data: ArrayList<ItemPostModel>,
    private val itemEvent: ItemEvents
) :
    RecyclerView.Adapter<TrendAdapter.ViewHolderTrend>() {

    inner class ViewHolderTrend(
        private var itemTrendView: ItemTrendBinding,
        var contxet: Context
    ) : RecyclerView.ViewHolder(itemTrendView.root) {

        @SuppressLint("SetTextI18n")
        fun setView(itemPost: ItemPostModel) {
            Glide.with(contxet)
                .load(itemPost.ImageUrl)
                .transform(RoundedCornersTransformation(32, 8))
                .into(itemTrendView.imgTrendMain)
            itemTrendView.txtTrendTitle.text = itemPost.Title
            itemTrendView.txtTrendSubtitle.text = itemPost.Subtitle
            itemTrendView.txtTrendInsight.text = itemPost.insight
            itemTrendView.txtTrendNumberItem.text = "${adapterPosition + 1}"
            itemTrendView.root.setOnClickListener {
                itemEvent.onItemClicked(itemPost = itemPost)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTrend =
        ViewHolderTrend(
            ItemTrendBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            parent.context
        )

    override fun onBindViewHolder(holder: ViewHolderTrend, position: Int) =
        holder.setView(data[position])

    override fun getItemCount(): Int = data.size

}