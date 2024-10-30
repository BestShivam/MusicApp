package com.example.musicapp


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Error -> private var _currentScreen : MutableState<Screen.DrawerScreen> =
    // mutableStateOf(Screen.DrawerScreen.AddAccount)
    // because it don't extend DrawerScreen Class with Screen class
    private var _currentScreen : MutableState<Screen> =
        mutableStateOf(Screen.DrawerScreen.Account)

    val currentScreen : MutableState<Screen>
        get() = _currentScreen

    fun setCurrentScreen(screen: Screen){
        _currentScreen.value = screen
    }
}