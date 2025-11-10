package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    val items: List<Book>,
    val totalItems: Int
)

@Serializable
data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String>? = null,
    val publisher: String? = null,
    val publishedDate: String? = null,
    val description: String? = null,
    val pageCount: Int? = null,
    val imageLinks: ImageLinks? = null,
)

@Serializable
data class ImageLinks(
    var smallThumbnail: String? = null,
    var thumbnail: String? = null
)