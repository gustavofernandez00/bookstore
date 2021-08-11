package com.gustavo.bookstore.data.repositories

import com.gustavo.bookstore.data.apimanager.BooksApiManager
import com.gustavo.bookstore.data.models.Response
import com.gustavo.bookstore.domain.entities.Book
import com.gustavo.bookstore.domain.repositories.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class BookRepositoryImpl constructor(
    private val apiManager: BooksApiManager
) : BookRepository {

    override fun getBooks(): Flow<Response<List<Book>>> = flow {
        emit(Response.Loading)
        val response = apiManager.getBooks().books.map {
            Book(it)
        }
        emit(Response.Success(response))
    }.catch { exception ->
        emit(Response.Error(exception))
    }

    override fun getBestSellers() {
        TODO("Not yet implemented")
    }

}