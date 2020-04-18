package com.reza.codelabs.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.reza.codelabs.R
import com.reza.codelabs.data.api.ApiClient
import com.reza.codelabs.data.api.IMAGE_BASE_URL
import com.reza.codelabs.data.api.TheMovieInterface
import com.reza.codelabs.data.repository.MovieDetailsRepository
import com.reza.codelabs.data.repository.NetworkState
import com.reza.codelabs.data.vo.MovieDetails
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovie : AppCompatActivity() {

    private lateinit var vm: DetailMovieViewModel
    private lateinit var repository: MovieDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movieId = intent.getIntExtra("id", 1)

        val apiService: TheMovieInterface = ApiClient.getClient()
        repository = MovieDetailsRepository(apiService)
        vm = getViewModel(movieId)

        vm.movieDetails.observe(this, Observer {
            bindUi(it)
        })

        vm.networkState.observe(this, Observer {
            progress_bar.visibility = if (it == NetworkState.LOADING) View.VISIBLE else View.GONE
            tv_error.visibility = if (it == NetworkState.ERROR) View.VISIBLE else View.GONE
        })
    }

    private fun bindUi(it: MovieDetails) {
        tv_title.text = it.title
        tv_desc.text = it.overview

        Glide.with(this)
            .load(IMAGE_BASE_URL + it.posterPath)
            .into(iv_poster)
    }

    private fun getViewModel(movieId: Int): DetailMovieViewModel {
        return ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return DetailMovieViewModel(repository, movieId) as T
            }
        })[DetailMovieViewModel::class.java]
    }
}