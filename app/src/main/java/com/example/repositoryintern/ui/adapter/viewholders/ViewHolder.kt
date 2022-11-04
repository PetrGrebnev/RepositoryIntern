package com.example.repositoryintern.ui.adapter.viewholders

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.repositoryintern.R
import com.example.repositoryintern.data.RecyclerViewItem
import com.example.repositoryintern.databinding.ItemChroniclesBinding
import com.example.repositoryintern.databinding.ItemImageProfileBinding
import com.example.repositoryintern.databinding.ItemMomentBinding
import com.example.repositoryintern.databinding.ItemPeopleBinding
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

sealed class ViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class ChroniclesViewHolder(
        private val binding: ItemChroniclesBinding
    ) : ViewHolder(binding) {

        fun bind(item: RecyclerViewItem.ImageChronicles) {
            binding.apply {
                Glide
                    .with(itemView.context)
                    .load(item.image)
                    .into(imageChronicles)
            }
        }
    }

    class MomentViewHolder(
        private val binding: ItemMomentBinding
    ) : ViewHolder(binding) {

        fun bind(item: RecyclerViewItem.ImageMoment) {
            binding.apply {
                Glide
                    .with(itemView.context)
                    .load(item.image)
                    .into(imageProfileMoment)
            }
        }
    }

    class ProfileViewHolder(
        private val binding: ItemImageProfileBinding
    ) : ViewHolder(binding) {

        fun bind(item: RecyclerViewItem.ImageProfile) {
            binding.apply {
                Glide
                    .with(itemView.context)
                    .load(item.image)
                    .into(imageProfile)
            }
        }
    }

    class PeopleViewHolder(
        private val binding: ItemPeopleBinding
    ) : ViewHolder(binding) {

        fun bind(
            item: RecyclerViewItem.People,
            clickSubject: PublishSubject<RecyclerViewItem.People>
        ) {
            binding.apply {
                Glide
                    .with(itemView.context)
                    .asBitmap()
                    .load(item.people.image)
                    .placeholder(R.drawable.im_placeholder)
                    .into(avatar)
                name.text = item.people.name
                setSubscribe(item.people.subscribe)
                btnSubscribe.setOnClickListener {
                    clickSubject.onNext(item)
                    setSubscribe(item.people.subscribe)
                }
            }
        }

        private fun setSubscribe(subscribe: Boolean) {
            binding.apply {
                if (subscribe) {
                    btnSubscribe.text = itemView.context.getText(R.string.title_btn_subscribe)
                    btnSubscribe.setTextColor(itemView.context.getColor(R.color.purple_200))
                } else {
                    btnSubscribe.text = itemView.context.getText(R.string.title_btn_unsubscribe)
                    btnSubscribe.setTextColor(itemView.context.getColor(R.color.grey_99))
                }
            }
        }
    }
}
