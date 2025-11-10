package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.data.BookshelfRepository
import com.example.bookshelf.data.NetworkBookshelfRepository
import com.example.bookshelf.model.Book
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BooksUiState {
    data class Success(val books: List<Book>) : BooksUiState
    data object Error : BooksUiState
    data object Loading : BooksUiState
}

class BookshelfViewModel(
    private val booksRepository: BookshelfRepository = NetworkBookshelfRepository()
) : ViewModel() {

    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        // Realizar una búsqueda inicial
        searchBooks("kotlin programming")
    }

    fun searchBooks(query: String) {
        viewModelScope.launch {
            booksUiState = BooksUiState.Loading
            booksUiState = try {
                val result = booksRepository.searchBooks(query)
                BooksUiState.Success(result.items)
            } catch (e: IOException) {
                BooksUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return BookshelfViewModel() as T
            }
        }
    }
}