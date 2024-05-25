package com.example.asm

sealed class Screens(val screen: String) {
    data object Home: Screens( "home")
    data object Favourite: Screens( "favorite")
    data object Notification: Screens( "notification")
    data object Profile: Screens( "profile")
}