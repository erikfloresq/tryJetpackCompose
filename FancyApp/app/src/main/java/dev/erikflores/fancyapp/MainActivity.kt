package dev.erikflores.fancyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.erikflores.fancyapp.ui.theme.FancyAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FancyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NewStory()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun NewStory() {
    val image = painterResource(R.drawable.header)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val imageModifier = Modifier.height(180.dp).fillMaxWidth()

        Image(painter = image,
              modifier = imageModifier,
              contentScale = ContentScale.Crop,
              contentDescription = "")
        Text("Hello world")
        Text("Hello erik")
        Text("Hello ios")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FancyAppTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun NewStoryPreview() {
    NewStory()
}