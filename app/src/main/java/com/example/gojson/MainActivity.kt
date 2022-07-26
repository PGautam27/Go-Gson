package com.example.gojson

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.gojson.presentation.HomeScreen
import com.example.gojson.presentation.JsonDataScreen
import com.example.gojson.presentation.ViewModel
import com.example.gojson.presentation.screens.Screens
import com.example.gojson.ui.theme.GoJsonTheme
import org.json.JSONObject


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoJsonTheme {
                val viewModel = ViewModel()
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screens.HomeScreen.route
                ) {
                    composable(Screens.HomeScreen.route) {
                        HomeScreen(context = this@MainActivity, navController,viewModel)
                    }
                    composable(Screens.JsonDataScreen.route) {
                        JsonDataScreen(viewModel = viewModel)
                    }
                }

            }
        }
    }
}

















//
//val queue = Volley.newRequestQueue(this@MainActivity)
//val url = "https://api.coinpaprika.com/v1/coins/btc-bitcoin"
//
//val stringRequest = StringRequest(
//    Request.Method.GET, apiLinkValue.value.text,
//    { response ->
//        Toast.makeText(this@MainActivity,"Worked",Toast.LENGTH_SHORT).show()
//        jsonValue.value = response
//        Toast.makeText(
//            applicationContext,
//            "Response: $response",
//            Toast.LENGTH_SHORT
//        ).show()
//    }
//) {  Toast.makeText(
//    applicationContext,
//    "Response: It didn't work",
//    Toast.LENGTH_SHORT
//).show() }
//
//queue.add(stringRequest)