package dev.erikflores.jetbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.erikflores.jetbasics.ui.theme.JetBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LabScreen("Android")
                }
            }
        }
    }
}

@Composable
fun LabScreen(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextElement(name)
        TextFieldElement()
    }
}

@Composable
fun TextElement(name: String) {
    Text(text = "Hello $name!",
        fontStyle = FontStyle.Italic,
        color = colorResource(id = R.color.purple_200),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TextFieldElement() {
    val textValue = remember { mutableStateOf("") }
    TextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label = {}
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBasicsTheme {
        LabScreen("Android")
    }
}