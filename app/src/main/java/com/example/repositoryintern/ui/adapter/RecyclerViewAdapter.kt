package com.example.repositoryintern.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.repositoryintern.R
import com.example.repositoryintern.databinding.ItemChroniclesBinding
import com.example.repositoryintern.databinding.ItemImageProfileBinding
import com.example.repositoryintern.databinding.ItemMomentBinding
import com.example.repositoryintern.ui.adapter.diffutils.ImageDiffUtilRecyclerViewAdapter
import com.example.repositoryintern.data.RecyclerViewItem
import com.example.repositoryintern.databinding.ItemPeopleBinding
import com.example.repositoryintern.ui.adapter.viewholders.ViewHolder
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class RecyclerViewAdapter :
    ListAdapter<RecyclerViewItem, ViewHolder>(ImageDiffUtilRecyclerViewAdapter()) {

    private val clickSubject = PublishSubject.create<RecyclerViewItem.People>()
    val clickEvent: Observable<RecyclerViewItem.People> = clickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            R.layout.item_chronicles -> ViewHolder.ChroniclesViewHolder(
                ItemChroniclesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_moment -> ViewHolder.MomentViewHolder(
                ItemMomentBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_image_profile -> ViewHolder.ProfileViewHolder(
                ItemImageProfileBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_people -> ViewHolder.PeopleViewHolder(
                ItemPeopleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provider")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder.ChroniclesViewHolder -> holder.bind(
                getItem(position) as RecyclerViewItem.ImageChronicles,
            )
            is ViewHolder.MomentViewHolder -> holder.bind(
                getItem(position) as RecyclerViewItem.ImageMoment,
            )
            is ViewHolder.ProfileViewHolder -> holder.bind(
                getItem(position) as RecyclerViewItem.ImageProfile,
            )
            is ViewHolder.PeopleViewHolder -> holder.bind(
                getItem(position) as RecyclerViewItem.People,
                clickSubject
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is RecyclerViewItem.ImageChronicles -> R.layout.item_chronicles
            is RecyclerViewItem.ImageMoment -> R.layout.item_moment
            is RecyclerViewItem.ImageProfile -> R.layout.item_image_profile
            is RecyclerViewItem.People -> R.layout.item_people
        }
    }

}