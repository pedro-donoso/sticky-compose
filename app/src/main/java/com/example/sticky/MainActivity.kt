package com.example.sticky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Screen {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        val grouped = countries.groupBy { it[0] }

                        grouped.forEach { (header, items) ->
                            stickyHeader {
                                Text(
                                    text = header.toString(),
                                    style = MaterialTheme.typography.headlineMedium,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(MaterialTheme.colorScheme.primary)
                                        .padding(16.dp)
                                )
                            }

                            items(items) { country ->
                                Text(
                                    text = country,
                                    modifier = Modifier.padding(16.dp),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Screen(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
                content()
        }
    }
}





