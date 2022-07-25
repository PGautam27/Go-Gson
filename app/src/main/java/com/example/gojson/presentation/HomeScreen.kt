package com.example.gojson.presentation

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(context:ComponentActivity) {
    val viewModel = ViewModel()
    val apiLinkValue = remember {
        mutableStateOf(TextFieldValue())
    }
    val jsonValue = viewModel.jsonData.observeAsState().value.toString()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(value = apiLinkValue.value, onValueChange = { apiLinkValue.value=it } , modifier = Modifier.width(
            LocalConfiguration.current.screenWidthDp.dp-100.dp), maxLines = 1)
        Text(
            text = jsonValue
        )
        Spacer(modifier = Modifier.padding(50.dp))
        Button(onClick = {
            viewModel.fetchLink(apiLinkValue.value.text,context)
        }) {
            Text(text = "Click Me")
        }
    }
}