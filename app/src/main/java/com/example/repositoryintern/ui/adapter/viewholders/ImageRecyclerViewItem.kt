package com.example.repositoryintern.ui.adapter.viewholders

sealed class ImageRecyclerViewItem {

    data class ImageProfile(
        val image: String
    ) : ImageRecyclerViewItem()

    data class ImageMoment(
        val image: String
    ) : ImageRecyclerViewItem()

    data class ImageChronicles(
        val image: String
    ) : ImageRecyclerViewItem()
}
