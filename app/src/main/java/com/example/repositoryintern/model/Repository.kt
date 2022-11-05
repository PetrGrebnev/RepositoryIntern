package com.example.repositoryintern.model

import com.example.repositoryintern.data.PeopleSubscriber
import com.example.repositoryintern.data.RecyclerViewItem
import com.github.javafaker.Faker
import javax.inject.Inject

class Repository @Inject constructor() {

    fun createListPeople(): MutableList<RecyclerViewItem.People> {
        val faker = Faker()
        val list = mutableListOf<RecyclerViewItem.People>()
        for (i in 0..40) {
            val name = faker.name().name()
            val avatar = faker.company().logo()
            val subscriber = true
            list.add(
                i,
                RecyclerViewItem.People(PeopleSubscriber(i, avatar, name = name, subscriber))
            )
        }
        return list
    }
}