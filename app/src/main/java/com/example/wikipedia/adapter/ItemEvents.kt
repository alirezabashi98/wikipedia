package com.example.wikipedia.adapter

import com.example.wikipedia.model.ItemPostModel

interface ItemEvents {

    fun onItemClicked(itemPost: ItemPostModel)

    fun onItemLongClicked(itemPost: ItemPostModel)

}