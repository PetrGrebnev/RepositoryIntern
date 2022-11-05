package com.example.repositoryintern.data

sealed class RecyclerViewItem {

    data class ImageProfile(
        val image: String
    ) : RecyclerViewItem()

    data class ImageMoment(
        val image: String
    ) : RecyclerViewItem()

    data class ImageChronicles(
        val image: String
    ) : RecyclerViewItem()

    data class People(
        val people: PeopleSubscriber
    ) : RecyclerViewItem()
}
