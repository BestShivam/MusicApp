package com.example.musicapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountView() {
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(8.dp),
    ){
        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row (){
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null,
                    modifier = Modifier.padding(8.dp))
                Column {
                    Text("Shivam kumar")
                    Text("my@Email", color = Color.Gray)
                }
            }
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null)
        }
        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
            Icon(painter = painterResource(id = R.drawable.outline_music_video_24), contentDescription = null,
                modifier = Modifier.padding(8.dp))
            Text(text = "My Music")
        }
        Divider()
    }
}