package com.clintpauldev.zomatosampleapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.clintpauldev.zomatosampleapp.data.repositories.ZomatoRepository

class ZomatoViewModel @ViewModelInject constructor(val zomatoRepository: ZomatoRepository) :
    ViewModel() {


}