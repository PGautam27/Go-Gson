package com.example.gojson.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun JsonDataScreen(viewModel: ViewModel) {
    val jsonData = viewModel.jsonData.observeAsState().value.toString()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = jsonData)
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Download file.txt")
        }
    }
}

