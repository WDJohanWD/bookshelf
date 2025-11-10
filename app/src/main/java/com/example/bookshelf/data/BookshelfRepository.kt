package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookResponse

/**
 * Interface that defines how to interact with the data layer
 */
interface BookshelfRepository {
    /** Search for books using a query string */
    suspend fun searchBooks(query: String): BookResponse
    
    /** Get details of a specific book by its ID */
    suspend fun getBook(id: String): Book
}