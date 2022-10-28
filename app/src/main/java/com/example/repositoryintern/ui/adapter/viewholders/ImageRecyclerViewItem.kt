package com.example.repositoryintern.ui.adapter.viewholders

sealed class ImageRecyclerViewItem {

    class ImageProfile(
        val image: String
    ) : ImageRecyclerViewItem()

    class ImageMoment(
        val image: String
    ) : ImageRecyclerViewItem()

    class ImageChronicles(
        val image: String
    ) : ImageRecyclerViewItem()
}
