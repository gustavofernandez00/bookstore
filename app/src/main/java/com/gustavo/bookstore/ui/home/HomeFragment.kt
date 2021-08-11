package com.gustavo.bookstore.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.gustavo.bookstore.R
import com.gustavo.bookstore.data.models.Response

class HomeFragment : Fragment(R.layout.home_fragment) {

    lateinit var viewmodelProvider: ViewModelProvider.Factory

    val viewModel: HomeViewModel by viewModels { viewmodelProvider }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservers()
    }

    private fun setObservers() = with(viewModel) {
        allBooks.observe(viewLifecycleOwner) {
            when(it) {
                is Response.Loading -> {} //showProgress
                is Response.Success -> {} //showTheView
                is Response.Error -> {} //showErrorView
            }
        }
    }

    companion object {
        fun newInstance() : HomeFragment = HomeFragment()
    }
}