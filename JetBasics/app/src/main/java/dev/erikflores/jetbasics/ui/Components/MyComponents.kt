package dev.erikflores.jetbasics.ui.Components

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import dev.erikflores.jetbasics.R

@Composable
fun SurfaceScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        MySurface(modifier = modifier.align(Alignment.Center))
    }
}

@Composable
fun MySurface(modifier: Modifier) {
    Surface(
        modifier = modifier.size(100.dp), // 1
        shape = RectangleShape,
        color = Color.LightGray, // 2
        contentColor = colorResource(id = R.color.purple_500), // 2
        elevation = 5.dp, // 3
        border = BorderStroke(1.dp, Color.Black) // 4
    ) {
        Column() {
            Text("Erik")
            Text("Flores")
            Text("Quispe")
        }
    }
}

@Composable
fun LayoutScreen() {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("element 1")
        Text("element 1")
        Text("element 1")
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
            focusedBorderColor = Color.Green,
            unfocusedBorderColor = Color.Blue
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
