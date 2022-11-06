package com.example.repositoryintern.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositoryintern.data.RecyclerViewItem
import com.example.repositoryintern.model.PeopleRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository: PeopleRepositoryImpl
): ViewModel() {

    private val _peopleLiveData = MutableLiveData<List<RecyclerViewItem.People>>()
    val peopleLiveData: LiveData<List<RecyclerViewItem.People>> = _peopleLiveData
    private var listPeople = mutableListOf<RecyclerViewItem.People>()

    init {
        getPeople()
    }

    private fun getPeople(){
        viewModelScope.launch(Dispatchers.IO) {
            listPeople = repository.createListPeople()
            _peopleLiveData.postValue(listPeople)
        }
    }

    fun clickSubscribe(item: RecyclerViewItem.People){
        listPeople[item.people.id].people.subscribe = !item.people.subscribe
        _peopleLiveData.value = listPeople
    }
}