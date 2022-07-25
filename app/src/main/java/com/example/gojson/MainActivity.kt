package com.example.gojson

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.gojson.ui.theme.GoJsonTheme
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoJsonTheme {
                val link = "https://api.coinpaprika.com/v1/coins"
                val jsonObject = JSONObject()
                val apiLinkValue = remember {
                    mutableStateOf(TextFieldValue())
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(value = apiLinkValue.value, onValueChange = { apiLinkValue.value=it } , modifier = Modifier.width(
                        LocalConfiguration.current.screenWidthDp.dp-100.dp), maxLines = 1)
                    Spacer(modifier = Modifier.padding(50.dp))
                    Button(onClick = {
                        val que = Volley.newRequestQueue(this@MainActivity)
                        val req = JsonObjectRequest(Request.Method.GET,link,jsonObject, {
                            Toast.makeText(this@MainActivity,it.toString(),Toast.LENGTH_SHORT).show()
                        }, {
                            Toast.makeText(this@MainActivity,"Couldn't fetch",Toast.LENGTH_SHORT).show()
                        })
                    }) {
                        Text(text = "Click Me")
                    }
                }
            }
        }
    }
}