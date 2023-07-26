package com.yapp.bol.presentation.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yapp.bol.domain.usecase.auth.GetAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
) : ViewModel() {

    private val _accessToken = MutableLiveData<String?>(null)
    val accessToken: LiveData<String?> = _accessToken

    private val  _animationState = MutableLiveData(false)
    val animationState: LiveData<Boolean> = _animationState

    init {
        viewModelScope.launch {
            delay(2000)
            _animationState.value = true
        }
    }

    fun getAccessToken() {
        viewModelScope.launch {
            getAccessTokenUseCase().collectLatest {
                _accessToken.value = it
            }
        }
    }
}
