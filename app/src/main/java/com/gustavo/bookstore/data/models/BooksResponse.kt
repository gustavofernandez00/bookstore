package com.gustavo.bookstore.data.models

import com.google.gson.annotations.SerializedName

data class ResultsResponse(
    @SerializedName("results") val results: BooksResponse
)

data class BooksResponse(
    @SerializedName("books") val books: List<BookResponse>
)

data class BookResponse(
    @SerializedName("isbn") val isbn: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("author") val author: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("genre") val genre: String? = null,
    @SerializedName("img") val img: String? = null,
    @SerializedName("imported") val imported: Boolean
)