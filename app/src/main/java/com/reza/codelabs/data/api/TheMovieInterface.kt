package com.reza.codelabs.data.api

import com.reza.codelabs.data.vo.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieInterface {

    @GET("movie/{id}")
    fun getMovieDetails(@Path("id") id: Int): Single<MovieDetails>
}