package dev.erikflores.jetbasics

import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        OutTextFieldElement()
        MyButton()
        MyRadioButton()
        MyFloatingActionButton()
        LoaderCircular()
        LoaderProgress()
        ShowAlertDialog()
    }
}

@Composable
fun TextElement(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(10.dp),
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
        modifier = Modifier.padding(10.dp),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label = { Text(stringResource(id = R.string.name_form)) }
    )
}

@Composable
fun OutTextFieldElement() {
    val textValue = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier.padding(10.dp),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label =  { Text(stringResource(id = R.string.email_form)) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Green,
            unfocusedBorderColor = Blue
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
    )
}

@Composable
fun MyButton() {
    Button(
        modifier = Modifier.padding(10.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.purple_200)),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.teal_200))
    ) {
        Text(
            text = "Press me",
            color = Color.White
        )
    }
}

@Composable
fun MyRadioButton() {
    val selectedButton = remember { mutableStateOf(0) }
    RadioButton(
        modifier = Modifier.padding(10.dp),
        colors = RadioButtonDefaults.colors(
            selectedColor = colorResource(id = R.color.teal_200),
            unselectedColor = colorResource(id = R.color.purple_200),
            disabledColor = colorResource(id = R.color.purple_500)
        ),
        selected = true,
        onClick = { selectedButton.value }
    )
}

@Composable
fun MyFloatingActionButton() {
//    ExtendedFloatingActionButton(
//        onClick = {},
//        backgroundColor = colorResource(id = R.color.purple_500),
//        contentColor = Color.White,
//        icon = {
//            Icon(Icons.Filled.Favorite, "")
//        },
//        text = { }
//    )
    FloatingActionButton(
        modifier = Modifier.padding(10.dp),
        onClick = {}
    ) {
        Icon(Icons.Filled.Favorite, "")
    }
}

@Composable
fun LoaderCircular() {
    CircularProgressIndicator(
        color = colorResource(id = R.color.purple_500),
        strokeWidth = 5.dp
    )
}

@Composable
fun LoaderProgress() {
    LinearProgressIndicator(
        color = colorResource(id = R.color.purple_500),
        progress = 0.5f
    )
}

@Composable
fun ShowAlertDialog() {
    var shouldShowDialog = remember { mutableStateOf(false) }

    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
            },
            title = { Text("Demo") },
            text = { Text("programamos algo?") },
            confirmButton = {
                Button(onClick = { }) {
                    Text("OK")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBasicsTheme {
        LabScreen("Android")
    }
}