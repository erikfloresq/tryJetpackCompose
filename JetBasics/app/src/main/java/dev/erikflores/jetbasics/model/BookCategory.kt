package dev.erikflores.jetbasics.model

import androidx.annotation.StringRes

data class BookCategory(@StringRes val categoryResourceId: Int, val bookImageResource: List<Int>)