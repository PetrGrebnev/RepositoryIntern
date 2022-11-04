package com.example.repositoryintern.di

import com.example.repositoryintern.ui.account.AccountFragment
import com.example.repositoryintern.ui.people.PeopleFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun injectAcc(fragment: AccountFragment)

    fun injectPeople(fragment: PeopleFragment)
}