package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookResponse
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.VolumeInfo

/**
 * Fake implementation of BookshelfRepository for testing
 */
class FakeBookshelfRepository : BookshelfRepository {
    override suspend fun searchBooks(query: String): BookResponse {
        // Return fake data for testing
        return BookResponse(
            items = listOf(
                Book(
                    id = "test1",
                    volumeInfo = VolumeInfo(
                        title = "Test Book 1",
                        authors = listOf("Author 1"),
                        publisher = "Test Publisher",
                        publishedDate = "2023",
                        description = "Test description 1",
                        pageCount = 100,
                        imageLinks = ImageLinks(
                            thumbnail = "https://example.com/test1.jpg",
                            smallThumbnail = "https://example.com/test1-small.jpg"
                        )
                    )
                ),
                Book(
                    id = "test2",
                    volumeInfo = VolumeInfo(
                        title = "Test Book 2",
                        authors = listOf("Author 2"),
                        publisher = "Test Publisher",
                        publishedDate = "2023",
                        description = "Test description 2",
                        pageCount = 200,
                        imageLinks = ImageLinks(
                            thumbnail = "https://example.com/test2.jpg",
                            smallThumbnail = "https://example.com/test2-small.jpg"
                        )
                    )
                )
            ),
            totalItems = 2
        )
    }

    override suspend fun getBook(id: String): Book {
        // Return fake data for testing
        return Book(
            id = id,
            volumeInfo = VolumeInfo(
                title = "Test Book",
                authors = listOf("Test Author"),
                publisher = "Test Publisher",
                publishedDate = "2023",
                description = "Test description",
                pageCount = 100,
                imageLinks = ImageLinks(
                    thumbnail = "https://example.com/test.jpg",
                    smallThumbnail = "https://example.com/test-small.jpg"
                )
            )
        )
    }
}