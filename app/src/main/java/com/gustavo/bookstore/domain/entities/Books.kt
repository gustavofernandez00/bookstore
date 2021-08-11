package com.gustavo.bookstore.domain.entities

import com.gustavo.bookstore.data.models.BookResponse

data class Book(
    val isbn: String?,
    val title: String?,
    val author: String?,
    val description: String?,
    val genre: String?,
    val img: String?,
    val imported: Boolean
) {
    //todo: add alternative response ?:
    constructor(bookResponse: BookResponse): this(
        isbn = bookResponse.isbn,
        title = bookResponse.title,
        author = bookResponse.author,
        description = bookResponse.description,
        genre = bookResponse.genre,
        img = bookResponse.img ?: "",
        imported = bookResponse.imported
    )
}


data class Books(
    val books : List<Book>
)
