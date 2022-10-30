package com.example.repositoryintern.ui.adapter.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.repositoryintern.ui.adapter.viewholders.ImageRecyclerViewItem

class ImageDiffUtilRecyclerViewAdapter: DiffUtil.ItemCallback<ImageRecyclerViewItem>() {
    override fun areItemsTheSame(
        oldItem: ImageRecyclerViewItem,
        newItem: ImageRecyclerViewItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: ImageRecyclerViewItem,
        newItem: ImageRecyclerViewItem
    ): Boolean {
        return oldItem == newItem
    }
}