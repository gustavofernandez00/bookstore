package com.gustavo.bookstore.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gustavo.bookstore.data.models.Response
import com.gustavo.bookstore.domain.entities.Book
import com.gustavo.bookstore.domain.repositories.BookRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel constructor(
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _allBooks = MutableLiveData<Response<List<Book>>>()
    val allBooks get() = _allBooks

    // todo: create a sealed class for this when
    fun getBooks() = bookRepository.getBooks().onEach {
        when(it) {
            is Response.Loading -> Response.Loading
            is Response.Success -> Response.Success(it.data)
            is Response.NotInitialized -> Response.NotInitialized
            is Response.Error -> Response.Error(it.exception)
        }.let {
            _allBooks.value = it
        }
    }.launchIn(viewModelScope)
}