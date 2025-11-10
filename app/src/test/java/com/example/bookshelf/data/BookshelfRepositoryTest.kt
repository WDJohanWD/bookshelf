package com.example.bookshelf.data

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BookshelfRepositoryTest {
    private lateinit var repository: BookshelfRepository

    @Before
    fun setup() {
        repository = FakeBookshelfRepository()
    }

    @Test
    fun searchBooks_returnsBookList() = runTest {
        val result = repository.searchBooks("test")
        assertEquals(2, result.items.size)
        assertEquals("test1", result.items[0].id)
        assertEquals("Test Book 1", result.items[0].volumeInfo.title)
    }

    @Test
    fun getBook_returnsBookDetails() = runTest {
        val result = repository.getBook("test1")
        assertEquals("test1", result.id)
        assertEquals("Test Book", result.volumeInfo.title)
        assertEquals("Test Author", result.volumeInfo.authors?.get(0))
    }
}