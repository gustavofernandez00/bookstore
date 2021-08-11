package com.gustavo.bookstore.data.apimanager

import com.gustavo.bookstore.data.models.ResultsResponse
import retrofit2.http.GET

interface BooksApi {
    @GET("books")
    suspend fun getBooks() : ResultsResponse
}