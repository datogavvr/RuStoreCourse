package com.practicum.vk_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.practicum.vk_kotlin.ui.theme.Vk_kotlinTheme
import androidx.core.net.toUri
import androidx.core.text.isDigitsOnly

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vk_kotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FirstScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var textValue by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textValue,
            onValueChange = { textValue = it.trimStart() },
            placeholder = { Text("Введите текст") }
        )
        // при пустом поле ввода кнопки неактивны
        Button(
            onClick = {
                val intent = Intent(context, SideActivity::class.java)
                intent.putExtra("text", textValue.trim())
                context.startActivity(intent)
            },
            enabled = textValue.trim().isNotEmpty(),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            ),
            content = { Text("Открыть вторую Activity") }
        )
        // при невалидных данных кнопка неактивна (номер от 8 до 15 цифр для разных стран и символ "+")
        Button(
            onClick = {
                val implicitIntent = Intent(Intent.ACTION_DIAL, "tel:${textValue.trim()}".toUri())
                context.startActivity(implicitIntent)
            },
            enabled =
                if (
                    textValue.trim().length < 8 ||
                    textValue.trim().length > 16
                    ) false // если слишком много или мало символов - номер невалиден
                else if (
                    textValue[0] == '+' &&
                    textValue.trim().length > 8 &&
                    textValue.trim().length < 17 &&
                    textValue.trim().substring(1).isDigitsOnly()
                    ) true // если первый символ "+" и все остальные символы цифры - номер валиден
                else if (
                    textValue.trim().length > 7 &&
                    textValue.trim().length < 16 &&
                    textValue.trim().isDigitsOnly()
                    ) true // если все символы цифры - номер валиден
                else false,
            colors = ButtonColors(
                containerColor = Color.Green,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            ),
            content = { Text("Позвонить другу") }
        )
        Button(
            onClick = {
                val systemIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, textValue)
                }
                context.startActivity(systemIntent)
            },
            enabled = textValue.trim().isNotEmpty(),
            colors = ButtonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            ),
            content = { Text("Поделиться текстом") }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Vk_kotlinTheme {
        FirstScreen()
    }
}