package com.example.tugas3

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas3.ui.theme.Tugas3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas3Theme {
                Surface(Modifier.fillMaxSize()) {
                    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        var input by remember {
                            mutableStateOf(mutableListOf<String>())
                        }

                        var displayText by remember {
                            mutableStateOf("")
                        }

                        var temp : String
                        var splitStr : List<String>

                        namaNim()

                        Spacer(modifier = Modifier.padding(bottom = 24.dp))

                        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                            OutlinedTextField(
                                value = displayText,
                                onValueChange = { displayText = it},
                                label = { Text(text = "input Number")})
                        }

                        Spacer(modifier = Modifier.padding(bottom = 24.dp))

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                                FilledTonalButton(
                                    onClick = {}) {
                                    Text(text = "")
                                }
                                FilledTonalButton(
                                    onClick = { /*TODO*/ }) {
                                    Text(text = "")
                                }
                                FilledTonalButton(
                                    onClick = { /*TODO*/ }) {
                                    Text(text = "")
                                }
                                FilledTonalButton(
                                    onClick = { input.clear()
                                        displayText = input.joinToString(separator = " ") },
                                    colors = ButtonDefaults.buttonColors(Color.Black)) {
                                    Text(text = "C")
                                }
                            }
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                                Button(
                                    onClick = { input.add("7")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = "7")
                                }
                                Button(
                                    onClick = { input.add("8")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = "8")
                                }
                                Button(
                                    onClick = { input.add("9")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = "9")
                                }
                                FilledTonalButton(
                                    onClick = { input.add("+")
                                        displayText = input.joinToString(separator = " ")},
                                    colors = ButtonDefaults.buttonColors(Color.Blue)) {
                                    Text(text = "+")
                                }
                            }
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                                Button(
                                    onClick = { input.add("4")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = "4")
                                }
                                Button(
                                    onClick = { input.add("5")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = "5")
                                }
                                Button(
                                    onClick = { input.add("6")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = "6")
                                }
                                FilledTonalButton(
                                    onClick = { input.add("-")
                                        displayText = input.joinToString(separator = " ")},
                                    colors = ButtonDefaults.buttonColors(Color.Red)) {
                                    Text(text = "-")
                                }
                            }
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                                Button(
                                    onClick = { input.add("1")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = "1")
                                }
                                Button(
                                    onClick = { input.add("2")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = "2")
                                }
                                Button(
                                    onClick = { input.add("3")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = "3")
                                }
                                FilledTonalButton(
                                    onClick = { input.add("*")
                                        displayText = input.joinToString(separator = " ")},
                                    colors = ButtonDefaults.buttonColors(Color(255, 215, 0))) {
                                    Text(text = "*")
                                }
                            }
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                                FilledTonalButton(
                                    onClick = { input.add(".")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = ".")
                                }
                                Button(
                                    onClick = { input.add("0")
                                        displayText = input.joinToString(separator = " ")}) {
                                    Text(text = "0")
                                }
                                FilledTonalButton(
                                    onClick = {
                                        temp = input.joinToString(separator = " ").replace(" ", "")
                                        splitStr = temp.split("(?=[+-/*])|(?<=[+-/*])".toRegex())
                                        input.clear()
                                        var delimiterIndex = 0
                                        for (i in splitStr.indices) {
                                            if (splitStr[i].length == 1) {
                                                input.add("${splitStr[i]}")
                                                delimiterIndex++
                                            } else {
                                                input.add("${splitStr[i]}")
                                            }
                                        }
                                        displayText = hitung(input).joinToString(separator = " ")
                                    }) {
                                    Text(text = " = ")
                                }
                                FilledTonalButton(
                                    onClick = { input.add("/")
                                        displayText = input.joinToString(separator = " ")},
                                    colors = ButtonDefaults.buttonColors(Color.Green)) {
                                    Text(text = "/")
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}

fun hitung(input: MutableList<String>) : MutableList<String>{
    var temp: Double
    var count = 0
    for (i in input.indices){
        if (input[i] == "*" || input[i] == "/" || input[i] == "-" || input[i] == "+") count++
    }

    while (count > 0){
        for (i in input.indices){
            if (input[i] == "*") {
                temp = input[i - 1].toDouble() * input[i + 1].toDouble()
                input.removeAt(i + 1)
                input.removeAt(i)
                input.removeAt(i - 1)
                input.add(i - 1, temp.toString())
                count--
                break
            } else if (input[i] == "/") {
                temp = input[i - 1].toDouble() / input[i + 1].toDouble()
                input.removeAt(i + 1)
                input.removeAt(i)
                input.removeAt(i - 1)
                input.add(i - 1, temp.toString())
                count--
                break
            } else if (input[i] == "-") {
                temp = input[i - 1].toDouble() - input[i + 1].toDouble()
                input.removeAt(i + 1)
                input.removeAt(i)
                input.removeAt(i - 1)
                input.add(i - 1, temp.toString())
                count--
                break
            } else if (input[i] == "+") {
                temp = input[i - 1].toDouble() + input[i + 1].toDouble()
                input.removeAt(i + 1)
                input.removeAt(i)
                input.removeAt(i - 1)
                input.add(i - 1, temp.toString())
                count--
                break
            }
        }
    }
    return input
}

@Preview(showBackground = true)
@Composable
fun display(){
    Column {
        namaNim()
        Spacer(modifier = Modifier.padding(bottom = 24.dp))
        inputForm()
        Spacer(modifier = Modifier.padding(bottom = 24.dp))
        numberButton()
    }
}

@Composable
fun namaNim(){
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Tugas 2", Modifier.padding(bottom = 12.dp) ,style = MaterialTheme.typography.displaySmall)
        Text(text = "Noval Raihan Ramadhan", style = MaterialTheme.typography.bodyLarge)
        Text(text = "225150407111056")
    }
}

@Composable
fun inputForm(){
    var displayText by remember {
        mutableStateOf("")
    }

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = displayText,
            onValueChange = { displayText = it},
            label = { Text(text = "input Number")})
    }
}

@Composable
fun numberButton(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            FilledTonalButton(
                onClick = {}) {
                Text(text = "")
            }
            FilledTonalButton(
                onClick = { /*TODO*/ }) {
                Text(text = "")
            }
            FilledTonalButton(
                onClick = { /*TODO*/ }) {
                Text(text = "")
            }
            FilledTonalButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Black)) {
                Text(text = "C")
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { /*TODO*/ }) {
                Text(text = "7")
            }
            Button(
                onClick = { /*TODO*/ }) {
                Text(text = "8")
            }
            Button(
                onClick = { /*TODO*/ }) {
                Text(text = "9")
            }
            FilledTonalButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Blue)) {
                Text(text = "+")
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { /*TODO*/ }) {
                Text(text = "4")
            }
            Button(
                onClick = { /*TODO*/ }) {
                Text(text = "5")
            }
            Button(
                onClick = { /*TODO*/ }) {
                Text(text = "6")
            }
            FilledTonalButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Red)) {
                Text(text = "-")
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { /*TODO*/ }) {
                Text(text = "1")
            }
            Button(
                onClick = { /*TODO*/ }) {
                Text(text = "2")
            }
            Button(
                onClick = { /*TODO*/ }) {
                Text(text = "3")
            }
            FilledTonalButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(255, 215, 0))) {
                Text(text = "*")
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            FilledTonalButton(
                onClick = { /*TODO*/ }) {
                Text(text = ".")
            }
            Button(
                onClick = { /*TODO*/ }) {
                Text(text = "0")
            }
            FilledTonalButton(
                onClick = { /*TODO*/ }) {
                Text(text = " = ")
            }
            FilledTonalButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Green)) {
                Text(text = "/")
            }
        }
    }
}