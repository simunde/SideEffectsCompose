package com.msid.composesideeffects

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.msid.composesideeffects.ui.theme.ComposeSideEffectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSideEffectsTheme {
                Counter()
            }
        }
    }
}

@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }
    val key = count.value % 3 == 0

    LaunchedEffect(key1 = key) {
        Log.d("Count", "Current Count: ${count.value}")
    }

    Button(onClick = { count.value++ }) {
        Text(text = "Increment count")
    }
}
