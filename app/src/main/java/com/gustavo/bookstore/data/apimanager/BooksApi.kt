package com.gustavo.bookstore.data.apimanager

import com.gustavo.bookstore.data.models.ResultsResponse

class BooksApi {
    @GET("books")
    suspend fun getBooks() : ResultsResponse
}