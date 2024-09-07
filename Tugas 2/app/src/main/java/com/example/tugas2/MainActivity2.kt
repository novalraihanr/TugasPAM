package com.example.tugas2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas2.ui.theme.Tugas2Theme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas2Theme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {

                    val hasil = intent.getStringExtra("hasil")

                    Row {
                        Text("Hasil = ", style = MaterialTheme.typography.displayMedium)
                        Text(" $hasil", style = MaterialTheme.typography.displayMedium)
                    }

                    Spacer(modifier = Modifier.padding(24.dp))

                    namaNim()

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun print()
{

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row {
            Text("Hasil = ", style = MaterialTheme.typography.displayMedium)
            Text(" 0", style = MaterialTheme.typography.displayMedium)
        }

        Spacer(modifier = Modifier.padding(24.dp))

        namaNim()
    }

}

@Composable
fun namaNim(){

    Text("Noval Raihan Ramadhan", style = MaterialTheme.typography.titleMedium)
    Text("225150407111056", style = MaterialTheme.typography.titleMedium)
}