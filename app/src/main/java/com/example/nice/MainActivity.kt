package com.example.nice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.nice.assistants.DataStoreManager
import com.example.nice.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val dataStoreManager = DataStoreManager(this)
            AppNavHost(navController = rememberNavController())
        }
    }
}

