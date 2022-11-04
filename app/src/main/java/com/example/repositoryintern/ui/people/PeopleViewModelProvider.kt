package com.example.repositoryintern.ui.people

import com.example.repositoryintern.model.Repository
import com.example.repositoryintern.utils.BaseViewModelFactory
import javax.inject.Inject

class PeopleViewModelProvider @Inject constructor(
    private val repository: Repository
) : BaseViewModelFactory<PeopleViewModel>(PeopleViewModel::class.java) {

    override fun createViewModel(): PeopleViewModel {
        return PeopleViewModel(repository)
    }
}