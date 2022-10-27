package com.example.repositoryintern

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.repositoryintern.databinding.AccountFragmentBinding

class AccountFragment: Fragment() {

    private var bindingFragment: AccountFragmentBinding? = null
    private val binding
        get() = bindingFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        bindingFragment = AccountFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }
}