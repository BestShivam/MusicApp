package com.example.musicapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Library(){
    LazyColumn {
        items(liberaryItem){
            item ->
            itemRow(icon = item.icon, name = item.name)
        }
    }
}

@Composable
fun itemRow(@DrawableRes icon : Int,
            name : String){
    Row (
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(painter = painterResource(id = icon),
                contentDescription = name,
                modifier = Modifier.padding(horizontal = 8.dp))
            Text(text = name)
        }
        Icon(imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight, contentDescription = null)
    }
    Divider(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp))
}