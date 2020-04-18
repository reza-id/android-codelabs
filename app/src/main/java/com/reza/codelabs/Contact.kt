package com.reza.codelabs

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Contact(
    val id: Int,
    name: String,
    var phone: String
) : BaseObservable() {
    @Bindable
    var name = name
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }
}