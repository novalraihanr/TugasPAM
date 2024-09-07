package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
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
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas2.ui.theme.Tugas2Theme

class MainActivity : ComponentActivity() {
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
                    judul()
                    Spacer(modifier = Modifier.padding(bottom = 24.dp))

                    Column{
                        var angka1 by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = angka1,
                            onValueChange = { angka1 = it },
                            label = { Text(text = "Masukkan angka pertama")},
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )

                        var angka2 by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = angka2,
                            onValueChange = { angka2 = it },
                            label = { Text(text = "Masukkan angka kedua")},
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )

                        Spacer(modifier = Modifier.padding(bottom = 24.dp))

                        val operator = listOf("+", "-", "*", "/")
                        val (selectedOption, onOptionSelected) = remember {
                            mutableStateOf(operator[0])
                        }

                        operator.forEach{ op ->
                            Row(
                                Modifier.selectable(selected = (op == selectedOption), onClick = {onOptionSelected(op)}),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                RadioButton(selected = (op == selectedOption), onClick = { onOptionSelected(op)})
                                Text(op)
                            }
                        }

                        Spacer(modifier = Modifier.padding(bottom = 24.dp))

                        var hasil : Int
                        Button(onClick = {
                            when(selectedOption){
                                "+" -> hasil = angka1.toInt() + angka2.toInt()
                                "-" -> hasil = angka1.toInt() - angka2.toInt()
                                "*" -> hasil = angka1.toInt() * angka2.toInt()
                                "/" -> hasil = angka1.toInt() / angka2.toInt()
                                else -> {
                                    hasil = -1
                                }
                            }

                            val intent = Intent(this@MainActivity, MainActivity2::class.java)
                            intent.putExtra("hasil",hasil.toString())
                            startActivity(intent)

//                            Toast.makeText(this@MainActivity, hasil.toString(),Toast.LENGTH_LONG).show()
                        }) {
                            Text("Hitung")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun display()
{

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        judul()
        Spacer(modifier = Modifier.padding(bottom = 24.dp))
        calc()
    }

}

@Composable
fun judul(){
    Text("Noval's Calculator", style = MaterialTheme.typography.titleLarge)
}

@Composable
fun  calc()
{
    Column{
        var angka1 by remember { mutableStateOf("") }

        OutlinedTextField(
            value = angka1,
            onValueChange = { angka1 = it },
            label = { Text(text = "Masukkan angka pertama")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        var angka2 by remember { mutableStateOf("") }

        OutlinedTextField(
            value = angka2,
            onValueChange = { angka2 = it },
            label = { Text(text = "Masukkan angka kedua")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        
        Spacer(modifier = Modifier.padding(bottom = 24.dp))

        val operator = listOf("+", "-", "*", "/")
        val (selectedOption, onOptionSelected) = remember {
            mutableStateOf(operator[0])
        }

        operator.forEach{ op ->
            Row(
                Modifier.selectable(selected = (op == selectedOption), onClick = {onOptionSelected(op)}),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RadioButton(selected = (op == selectedOption), onClick = { onOptionSelected(op)})
                Text(op)
            }
        }

        Spacer(modifier = Modifier.padding(bottom = 24.dp))

        var hasil : Int
        Button(onClick = {
             when(selectedOption){
                "+" -> hasil = angka1.toInt() + angka2.toInt()
                "-" -> hasil = angka1.toInt() - angka2.toInt()
                "*" -> hasil = angka1.toInt() * angka2.toInt()
                "/" -> hasil = angka1.toInt() / angka2.toInt()
                else -> {
                    hasil = -1
                }
            }
        }) {
            Text("Hitung")
        }
    }
}