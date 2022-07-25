package com.example.gojson.presentation.screens

sealed class Screens(val route: String) {
    object HomeScreen : Screens("home_screen")
    object JsonDataScreen : Screens("json_data_screen")
}