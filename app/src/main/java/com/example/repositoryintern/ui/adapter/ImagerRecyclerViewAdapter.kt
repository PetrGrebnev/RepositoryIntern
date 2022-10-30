package com.example.repositoryintern.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.repositoryintern.R
import com.example.repositoryintern.databinding.ItemChroniclesBinding
import com.example.repositoryintern.databinding.ItemImageProfileBinding
import com.example.repositoryintern.databinding.ItemMomentBinding
import com.example.repositoryintern.ui.adapter.diffutils.ImageDiffUtilRecyclerViewAdapter
import com.example.repositoryintern.ui.adapter.viewholders.ImageRecyclerViewItem
import com.example.repositoryintern.ui.adapter.viewholders.ImageViewHolder

class ImagerRecyclerViewAdapter :
    ListAdapter<ImageRecyclerViewItem, ImageViewHolder>(ImageDiffUtilRecyclerViewAdapter()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return when (viewType) {
            R.layout.item_chronicles -> ImageViewHolder.ChroniclesViewHolder(
                ItemChroniclesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_moment -> ImageViewHolder.MomentViewHolder(
                ItemMomentBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_image_profile -> ImageViewHolder.ProfileViewHolder(
                ItemImageProfileBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provider")
        }
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        when (holder) {
            is ImageViewHolder.ChroniclesViewHolder -> holder.bind(
                getItem(position) as ImageRecyclerViewItem.ImageChronicles,
                holder.itemView.context
            )
            is ImageViewHolder.MomentViewHolder -> holder.bind(
                getItem(position) as ImageRecyclerViewItem.ImageMoment,
                holder.itemView.context
            )
            is ImageViewHolder.ProfileViewHolder -> holder.bind(
                getItem(position) as ImageRecyclerViewItem.ImageProfile,
                holder.itemView.context
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ImageRecyclerViewItem.ImageChronicles -> R.layout.item_chronicles
            is ImageRecyclerViewItem.ImageMoment -> R.layout.item_moment
            is ImageRecyclerViewItem.ImageProfile -> R.layout.item_image_profile
        }
    }

}