package com.reza.codelabs.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.reza.codelabs.data.repository.MovieDetailsRepository
import com.reza.codelabs.data.repository.NetworkState
import com.reza.codelabs.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class DetailMovieViewModel(private val movieRepository: MovieDetailsRepository, id: Int) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable, id)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}