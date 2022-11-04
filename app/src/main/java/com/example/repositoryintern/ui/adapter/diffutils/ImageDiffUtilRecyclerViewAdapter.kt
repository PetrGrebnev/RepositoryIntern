package com.example.repositoryintern.ui.adapter.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.repositoryintern.data.RecyclerViewItem

class ImageDiffUtilRecyclerViewAdapter : DiffUtil.ItemCallback<RecyclerViewItem>() {
    override fun areItemsTheSame(
        oldItem: RecyclerViewItem,
        newItem: RecyclerViewItem
    ): Boolean {
        return when (newItem) {
            is RecyclerViewItem.ImageChronicles -> when (oldItem) {
                is RecyclerViewItem.ImageChronicles -> oldItem == newItem
                else -> false
            }
            is RecyclerViewItem.ImageMoment -> when (oldItem) {
                is RecyclerViewItem.ImageMoment -> oldItem == newItem
                else -> false
            }
            is RecyclerViewItem.ImageProfile -> when (oldItem) {
                is RecyclerViewItem.ImageProfile -> oldItem == newItem
                else -> false
            }
            is RecyclerViewItem.People -> when (oldItem) {
                is RecyclerViewItem.People -> oldItem == newItem
                else -> false
            }
        }
    }

    override fun areContentsTheSame(
        oldItem: RecyclerViewItem,
        newItem: RecyclerViewItem
    ): Boolean {
        return when (newItem) {
            is RecyclerViewItem.ImageChronicles -> when (oldItem) {
                is RecyclerViewItem.ImageChronicles -> oldItem.image == newItem.image
                else -> false
            }
            is RecyclerViewItem.ImageMoment -> when (oldItem) {
                is RecyclerViewItem.ImageMoment -> oldItem.image == newItem.image
                else -> false
            }
            is RecyclerViewItem.ImageProfile -> when (oldItem) {
                is RecyclerViewItem.ImageProfile -> oldItem.image == newItem.image
                else -> false
            }
            is RecyclerViewItem.People -> when (oldItem) {
                is RecyclerViewItem.People -> oldItem.people.subscribe == oldItem.people.subscribe &&
                        oldItem.people.id == newItem.people.id
                else -> false
            }
        }
    }
}