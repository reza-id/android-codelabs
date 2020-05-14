package com.reza.codelabs.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EggTimerViewModelFactory(private val app: Application) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EggTimerViewModel::class.java)) {
            return EggTimerViewModel(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
