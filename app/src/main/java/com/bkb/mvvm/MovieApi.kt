package com.bkb.mvvm

import com.bkb.mvvm.model.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : retrofit2.Call<Movies>
}
