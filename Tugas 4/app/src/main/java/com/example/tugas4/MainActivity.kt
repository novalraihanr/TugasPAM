package com.example.tugas4

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas4.ui.theme.Tugas4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas4Theme {
                Surface(Modifier.fillMaxSize()) {
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        val data = remember {
                            mutableStateListOf<displayData>()
                        }

                        var text1 by remember {
                            mutableStateOf("")
                        }

                        var text2 by remember {
                            mutableStateOf("")
                        }

                        namaNim()
                        
                        Spacer(modifier = Modifier.padding(vertical = 10.dp))

                        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                            OutlinedTextField(
                                value = text1,
                                onValueChange = { text1 = it},
                                label = { Text(text = "input a Word")})

                            Spacer(modifier = Modifier.padding(bottom = 12.dp))

                            OutlinedTextField(
                                value = text2,
                                onValueChange = { text2 = it},
                                label = { Text(text = "input a Word")})

                            Spacer(modifier = Modifier.padding(bottom = 12.dp))

                            Button(
                                onClick = { if(text1.isNotBlank() && text2.isNotBlank()) {
                                    data.add(displayData(text1, text2))
                                    text1 = ""
                                    text2 = ""
                                }
                                }, Modifier.width(300.dp)) {
                                Text(text = "Submit")
                            }
                        }

                        Spacer(modifier = Modifier.padding(vertical = 10.dp))

                        RecyclerView(display = data)
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun display(){
        Column {
            input()

            Spacer(modifier = Modifier.padding(vertical = 10.dp))
        }
    }

    @Composable
    fun namaNim(){
        Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Tugas 4", Modifier.padding(bottom = 12.dp) ,style = MaterialTheme.typography.displaySmall)
            Text(text = "Noval Raihan Ramadhan", style = MaterialTheme.typography.bodyLarge)
            Text(text = "225150407111056")
        }
    }

    @Composable
    fun input(){
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            var text1 by remember {
                mutableStateOf("")
            }

            var text2 by remember {
                mutableStateOf("")
            }

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = text1,
                    onValueChange = { text1 = it},
                    label = { Text(text = "input Number")})

                Spacer(modifier = Modifier.padding(bottom = 12.dp))

                OutlinedTextField(
                    value = text1,
                    onValueChange = { text1 = it},
                    label = { Text(text = "input Number")})

                Spacer(modifier = Modifier.padding(bottom = 12.dp))

                Button(
                    onClick = { /*TODO*/ }, Modifier.width(300.dp)) {
                    Text(text = "Submit")
                }
            }
        }
    }

    @Composable
    fun displayCard(satu: String, dua: String){
        Card(
            Modifier
                .padding(horizontal = 8.dp, vertical = 5.dp)
                .fillMaxWidth(), RoundedCornerShape(CornerSize(10.dp)), elevation = CardDefaults.cardElevation(4.dp)) {
            Row(Modifier.padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Image",
                    Modifier
                        .padding(8.dp)
                        .size(60.dp)
                        .clip(
                            RoundedCornerShape(CornerSize(6.dp))
                        )
                        .align(Alignment.CenterVertically))

                Column(
                    Modifier
                        .height(70.dp)
                        .padding(horizontal = 5.dp), verticalArrangement = Arrangement.SpaceAround) {
                    Text(text = satu)
                    Text(text = dua)
                }
            }
        }
    }

    @Composable
    fun RecyclerView(display: List<displayData>) {
        LazyColumn {
            items(display){
                displayCard(satu = it.satu, dua = it.dua)
            }
        }
    }
}