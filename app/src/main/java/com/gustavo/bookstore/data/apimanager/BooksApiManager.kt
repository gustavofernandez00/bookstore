package com.gustavo.bookstore.data.apimanager

import com.gustavo.bookstore.data.models.BooksResponse

class BooksApiManager constructor(apiClient: RetrofitApiClient) {
    private val booksApi : BooksApi = apiClient.createService(BooksApi::class.java)

    suspend fun getBooks() : BooksResponse = booksApi.getBooks().results
}