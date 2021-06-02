package dev.erikflores.jetbasics

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.erikflores.jetbasics.model.*

@Composable
fun BooksScreen() {
    BooksList()
}

@Composable
fun BooksList() {
    LazyColumn {
        items(
            items = booksList,
            itemContent = {
                BookItem(it)
            }
        )
    }
}

@Composable
fun BookItem(bookCategory: BookCategory, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(id = bookCategory.categoryResourceId),
            modifier = Modifier.padding(all = 10.dp),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.purple_700)
        )
        Spacer(modifier = modifier.height(8.dp))
        LazyRow {
            items(bookCategory.bookImageResource) { items ->
                BookImage(imageResource = items)
            }
        }
    }
}

@Composable
fun BookImage(imageResource: Int) {
    Image(
       modifier = Modifier
           .size(170.dp, 200.dp)
           .padding(all = 10.dp),
       painter = painterResource(id = imageResource),
       contentDescription = stringResource(id = R.string.book_image),
        contentScale = ContentScale.FillBounds
    )
}




