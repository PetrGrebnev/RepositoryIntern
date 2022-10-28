package com.example.repositoryintern.ui.adapter.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.repositoryintern.databinding.ItemChroniclesBinding
import com.example.repositoryintern.databinding.ItemImageProfileBinding
import com.example.repositoryintern.databinding.ItemMomentBinding

sealed class ImageViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class ChroniclesViewHolder(
        private val binding : ItemChroniclesBinding
    ) : ImageViewHolder(binding) {

        fun bind(item: ImageRecyclerViewItem.ImageChronicles, context: Context){
            binding.apply {
                Glide
                    .with(context)
                    .load(item.image)
                    .into(imageChronicles)
            }
        }
    }

    class MomentViewHolder(
        private val binding: ItemMomentBinding
    ) : ImageViewHolder(binding) {

        fun bind(item: ImageRecyclerViewItem.ImageMoment, context: Context){
            binding.apply {
                Glide
                    .with(context)
                    .load(item.image)
                    .into(imageProfileMoment)
            }
        }
    }

    class ProfileViewHolder(
        private val binding: ItemImageProfileBinding
    ) : ImageViewHolder(binding) {

        fun bind(item: ImageRecyclerViewItem.ImageProfile, context: Context){
            binding.apply {
                Glide
                    .with(context)
                    .load(item.image)
                    .into(imageProfile)
            }
        }
    }
}
