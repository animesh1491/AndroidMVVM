package com.example.simplemvvmexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class FragmentInteractionVM : ViewModel() {

    private val _likeCount = MutableLiveData(0)
    val likeCount: LiveData<Int> = _likeCount

    private val _clickedFrom = MutableLiveData<String>("FragmentA")
    val clickedFrom: LiveData<String> = _clickedFrom

    fun clickEvent(clickedFrom: String) {
        _clickedFrom.value = clickedFrom
    }

    fun hitLike() {
        _likeCount.value = (likeCount.value ?: 0) + 1
    }

    val popularity: LiveData<Popularity> = Transformations.map(_likeCount) {
        when {
            it > 10 -> Popularity.STAR
            it > 5 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }

    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}

