package com.example.repositoryintern.model

import com.example.repositoryintern.data.PeopleSubscriber
import com.example.repositoryintern.data.RecyclerViewItem
import com.github.javafaker.Faker
import dagger.hilt.components.SingletonComponent
import it.czerwinski.android.hilt.annotations.BoundTo
import javax.inject.Inject

interface PeopleRepository{

    suspend fun createListPeople(): MutableList<RecyclerViewItem.People>
}

@BoundTo(supertype = PeopleRepository::class, component = SingletonComponent::class)
class PeopleRepositoryImpl @Inject constructor(): PeopleRepository {

    override suspend fun createListPeople(): MutableList<RecyclerViewItem.People> {
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