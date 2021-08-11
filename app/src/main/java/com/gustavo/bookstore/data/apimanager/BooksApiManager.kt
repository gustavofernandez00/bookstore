package com.gustavo.bookstore.data.apimanager

import com.gustavo.bookstore.data.models.BooksResponse

class BooksApiManager constructor(apiClient: RetrofitApiClient) {

    //todo: inject this
    private val retrofitApiClient by lazy {
        RetrofitApiClient(
            "https://raw.githubusercontent.com/ejgteja/files/main/"
        )
    }

    private val booksApi : BooksApi = retrofitApiClient.createService(BooksApi::class.java)

    suspend fun getBooks() : BooksResponse = booksApi.getBooks().results
}