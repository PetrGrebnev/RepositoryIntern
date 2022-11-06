package com.example.repositoryintern.ui.people

import com.example.repositoryintern.model.PeopleRepositoryImpl
import com.example.repositoryintern.utils.BaseViewModelFactory
import javax.inject.Inject

class PeopleViewModelProvider @Inject constructor(
    private val repository: PeopleRepositoryImpl
) : BaseViewModelFactory<PeopleViewModel>(PeopleViewModel::class.java) {

    override fun createViewModel(): PeopleViewModel {
        return PeopleViewModel(repository)
    }
}