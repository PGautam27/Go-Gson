package com.example.gojson.presentation

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.ComponentActivity
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
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.PermissionChecker.checkSelfPermission

@Composable
fun JsonDataScreen(viewModel: ViewModel,context: ComponentActivity) {
    val jsonData = viewModel.jsonData.observeAsState().value.toString()
    val STORAGE_PERMISSION_CODE = 1000
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = jsonData)
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(context,Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                        PackageManager.PERMISSION_DENIED){
                    requestPermissions(context,arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),STORAGE_PERMISSION_CODE)
                } else{
                    startDownloading()
                }
            }
            else{
                startDownloading()
            }
        }) {
            Text(text = "Download file.txt")
        }
    }
}


fun startDownloading(){

}