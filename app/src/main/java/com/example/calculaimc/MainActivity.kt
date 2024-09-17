package com.example.calculaimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        TextField(
            value = peso,
            onValueChange = onChangePeso
        )

        Spacer(modifier = Modifier.height(10.dp))

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