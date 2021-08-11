package com.gustavo.bookstore.domain.repositories

import com.gustavo.bookstore.data.models.Response
import com.gustavo.bookstore.domain.entities.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getBooks() : Flow<Response<List<Book>>>

    fun getBestSellers()
}