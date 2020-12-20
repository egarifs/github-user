package com.firdauscode.github.model


data class SearchModel(val items: ArrayList<Items>) {
    data class Items(
        val id: Int,
        val login: String,
        val avatar_url: String
    )
}

