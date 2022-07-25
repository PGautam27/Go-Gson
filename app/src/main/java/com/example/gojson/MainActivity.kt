package com.example.gojson

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.gojson.ui.theme.GoJsonTheme
import org.json.JSONObject


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoJsonTheme {
                val link = "https://random-data-api.com/api/blood/random_blood"
                val jsonObject = JSONObject()
                val apiLinkValue = remember {
                    mutableStateOf(TextFieldValue())
                }
                val jsonValue = remember {
                    mutableStateOf(String())
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    OutlinedTextField(value = apiLinkValue.value, onValueChange = { apiLinkValue.value=it } , modifier = Modifier.width(
//                        LocalConfiguration.current.screenWidthDp.dp-100.dp), maxLines = 1)
                    Text(
                        text = jsonValue.value
                    )
                    Spacer(modifier = Modifier.padding(50.dp))
                    Button(onClick = {
                        val queue = Volley.newRequestQueue(this@MainActivity)
                        val url = "https://api.coinpaprika.com/v1/coins/btc-bitcoin"

                        val stringRequest = StringRequest(
                            Request.Method.GET, url,
                            { response ->
                                Toast.makeText(this@MainActivity,"Worked",Toast.LENGTH_SHORT).show()
                                jsonValue.value = response
                                Toast.makeText(
                                    applicationContext,
                                    "Response: $response",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        ) {  Toast.makeText(
                            applicationContext,
                            "Response: It didn't work",
                            Toast.LENGTH_SHORT
                        ).show() }

                        queue.add(stringRequest)
                    }) {
                        Text(text = "Click Me")
                    }
                }
            }
        }
    }
}