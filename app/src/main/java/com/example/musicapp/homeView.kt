package com.example.musicapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun homeView(){
    val categories = listOf<String>("Hits","Happy","Workout","Running","TGIF","Yoga")
    val grouped = listOf<String>("New Release","Favorites","Top Rated").groupBy { it[0] }
    LazyColumn {
        grouped.forEach {
            stickyHeader { 
                Text(modifier = Modifier.padding(8.dp),text = it.value[0],
                    style = MaterialTheme.typography.titleMedium)
                LazyRow {
                    items(categories){cat ->
                        BrowerItem(cat,R.drawable.baseline_queue_music_24)
                    }
                }
            }
        }
    }
}

@Composable
fun BrowerItem(cat : String,drawable : Int){
    Card(
        modifier = Modifier.size(200.dp)
            .padding(16.dp),
        border = BorderStroke(2.dp, color = Color.Gray),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp

    ) {
        Column (modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = cat, style = MaterialTheme.typography.headlineSmall)
            Icon(painter = painterResource(id = drawable), contentDescription = cat,
                tint = Color.Gray,
                modifier = Modifier.size(64.dp))
        }
    }
}