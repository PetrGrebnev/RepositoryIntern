package com.example.repositoryintern.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.repositoryintern.data.RecyclerViewItem
import com.example.repositoryintern.databinding.PeopleFragmentBinding
import com.example.repositoryintern.ui.adapter.RecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@AndroidEntryPoint
class PeopleFragment: Fragment() {

    private var bindingFragment: PeopleFragmentBinding? = null
    private val binding
        get() = bindingFragment

    private lateinit var adapter: RecyclerViewAdapter
    private val vm: PeopleViewModel by viewModels()

    private var subscribe: Disposable? = null
    private var liveData : LiveData<List<RecyclerViewItem.People>>? = null
    private val observer: (List<RecyclerViewItem.People>) -> Unit = {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = PeopleFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding?.appBarPeopleFragment?.setupWithNavController(navController, appBarConfiguration)
        adapterCreate()
        setupItemClick()
    }

    private fun adapterCreate() {
        adapter = RecyclerViewAdapter()
        binding?.apply{
            listPeople.adapter = adapter
        }
        observe()
    }

    private fun observe() {
        liveData?.removeObserver(observer)
        liveData = vm.peopleLiveData.also {
            it.observe(viewLifecycleOwner, observer)
        }
    }

    private fun setupItemClick() {
        subscribe = adapter.clickEvent
            .subscribe {
                vm.clickSubscribe(it)
                Toast.makeText(requireContext(), "Clicked on ${it.people.name}", Toast.LENGTH_SHORT).show()
            }
        observe()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscribe?.dispose()
        bindingFragment = null
    }
}