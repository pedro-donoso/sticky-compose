package com.example.sticky

//importaciones
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

//clase principal
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    //se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //se crea el contenido de la actividad
        setContent {
            //se crea el tema
            MaterialTheme {
                //se crea la pantalla
                Screen {
                    //se crea la lista de paises
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        //se agrupan los paises por la primera letra
                        val grouped = countries.groupBy { it[0] }

                        //se crea la lista de paises
                        grouped.forEach { (header, items) ->
                            //se crea el encabezado
                            stickyHeader {
                                //se crea el texto del encabezado
                                Text(
                                    text = header.toString(),
                                    style = MaterialTheme.typography.headlineMedium,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(MaterialTheme.colorScheme.primary)
                                        .padding(16.dp)
                                )
                            }

                            //se crea la lista de paises
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

//funcion para crear el tema
@Composable
fun Screen(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.secondary) {
                content()
        }
    }
}





