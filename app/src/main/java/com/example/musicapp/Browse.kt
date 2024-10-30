package com.example.musicapp

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable

@Composable
fun Browse() {
    val categories = listOf<String>("Hits","Happy","Workout","Running","TGIF","Yoga")
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(categories){
            cat ->
            BrowerItem(cat = cat, drawable = R.drawable.baseline_queue_music_24)
        }
    }
}