package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookResponse
import com.example.bookshelf.network.BookshelfApi

/**
 * Implementation of BookshelfRepository that uses the Google Books API
 */
class NetworkBookshelfRepository : BookshelfRepository {
    override suspend fun searchBooks(query: String): BookResponse {
        val response = BookshelfApi.retrofitService.searchBooks(query)
        // Convert http URLs to https
        response.items.forEach { book ->
            book.volumeInfo.imageLinks?.let { links ->
                links.thumbnail?.let { thumbnail ->
                    if (thumbnail.startsWith("http://")) {
                        links.thumbnail = thumbnail.replace("http://", "https://")
                    }
                }
                links.smallThumbnail?.let { smallThumbnail ->
                    if (smallThumbnail.startsWith("http://")) {
                        links.smallThumbnail = smallThumbnail.replace("http://", "https://")
                    }
                }
            }
        }
        return response
    }

    override suspend fun getBook(id: String): Book {
        val book = BookshelfApi.retrofitService.getBook(id)
        // Convert http URLs to https
        book.volumeInfo.imageLinks?.let { links ->
            links.thumbnail?.let { thumbnail ->
                if (thumbnail.startsWith("http://")) {
                    links.thumbnail = thumbnail.replace("http://", "https://")
                }
            }
            links.smallThumbnail?.let { smallThumbnail ->
                if (smallThumbnail.startsWith("http://")) {
                    links.smallThumbnail = smallThumbnail.replace("http://", "https://")
                }
            }
        }
        return book
    }
}