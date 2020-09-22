package com.apgroup.boomer.viewModelFiles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFiveAndSix
    ( private val level:Int ,private val seconds:Long): ViewModelProvider.NewInstanceFactory() {

        override fun <T: ViewModel> create(modelClass:Class<T>): T {
            return LevelFiveAndSixGameEngine(level,seconds) as T

    }
}