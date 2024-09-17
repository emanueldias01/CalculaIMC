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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculaimc.ui.theme.CalculaImcTheme
import java.text.NumberFormat

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

    var imc by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        TextFields(peso = pesoInput,
            altura = alturaInput,
            onChangePeso = {pesoInput = it},
            onChangeAltura = {alturaInput = it}
            )

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            var result = calculaImc(peso, altura)
            imc = "Seu IMC é de : $result"
        }) {
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Calcular",
                fontSize = 20.sp,
                )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = imc,
            fontSize = 20.sp,
            modifier = Modifier.padding(30.dp)
            
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
            onValueChange = onChangePeso,
            label = { Text(text = stringResource(id = R.string.peso_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = stringResource(id = R.string.altura_txt))
        TextField(
            value = altura,
            onValueChange = onChangeAltura,
            label = { Text(text = stringResource(id = R.string.altura_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )

    }
}

internal fun calculaImc(peso : Double, altura: Double) : String{
    val result = peso/(altura*altura)
    return NumberFormat.getNumberInstance().format(result)
}

@Preview(showBackground = true)
@Composable
fun AllScreenPreview() {
    CalculaImcTheme {
        AllScreen()
    }
}