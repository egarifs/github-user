package com.firdauscode.github.retrofit

import com.firdauscode.github.model.SearchModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiEndpoint {
    @GET("search/users?q=sidiqpermana")
    @Headers("Authorization: token 7904182cb544c52b7b1d9f59c3b28ccd1d158193")
    fun getSearchUser(): Call<SearchModel>
}