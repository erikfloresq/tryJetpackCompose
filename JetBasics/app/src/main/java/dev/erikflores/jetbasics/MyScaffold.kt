package dev.erikflores.jetbasics

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import kotlinx.coroutines.CoroutineScope

@Composable
fun MyScaffold() {
    val scaffoldState: ScaffoldState= rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.purple_500),
        content = { MyRow() },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState) },
        bottomBar = { MyBottomAppBar() },
        drawerContent = { MyColumn() }
    )
}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState) {

}

@Composable
fun MyBottomAppBar() {

}

@Composable
fun MyRow() {

}

@Composable
fun MyColumn() {

}
