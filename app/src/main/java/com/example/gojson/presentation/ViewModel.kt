package com.example.gojson.presentation

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class ViewModel():ViewModel() {

    private val link = MutableLiveData<String>()

    private val _jsonData = MutableLiveData<String>()
    val jsonData:LiveData<String> = _jsonData

    fun fetchLink(activeLink : String, context:ComponentActivity){
        link.value = activeLink
        convertJsonData(context)
    }

    private fun convertJsonData(context: ComponentActivity){
        val queue = Volley.newRequestQueue(context)

        val stringRequest = StringRequest(
            Request.Method.GET, link.value.toString(),
            { response ->
                _jsonData.value = response
            }
        ) {
            Toast.makeText(
                context,
                "Response: It didn't work",
                Toast.LENGTH_SHORT
            ).show()
        }

        queue.add(stringRequest)
    }

}