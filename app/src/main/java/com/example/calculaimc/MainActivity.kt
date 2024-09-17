package com.example.calculaimc

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculaimc.ui.theme.CalculaImcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculaImcTheme {
                AllScreen()
            }
        }
    }
}

@Composable
fun AllScreen(modifier: Modifier = Modifier){

    var pesoInput by remember { mutableStateOf("") }
    var alturaInput by remember{ mutableStateOf("") }

    val peso = pesoInput.toDoubleOrNull() ?: 0.0
    val altura = alturaInput.toDoubleOrNull() ?: 0.0

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        TextFields(peso = pesoInput,
            altura = alturaInput,
            onChangePeso = {pesoInput = it},
            onChangeAltura = {alturaInput = it}
            )


    }


}

@Composable
fun TextFields(
    modifier: Modifier = Modifier,
    peso: String,
    altura: String,
    onChangePeso: (String) -> Unit,
    onChangeAltura: (String) -> Unit
    ){
    Column {
        Text(text = stringResource(id = R.string.peso_txt))
        TextField(
            value = peso,
            onValueChange = onChangePeso
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = stringResource(id = R.string.altura_txt))
        TextField(
            value = altura,
            onValueChange = onChangeAltura
        )

    }
}

@Preview(showBackground = true)
@Composable
fun AllScreenPreview() {
    CalculaImcTheme {
        AllScreen()
    }
}