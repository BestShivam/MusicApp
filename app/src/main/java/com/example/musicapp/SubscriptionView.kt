package com.example.musicapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun SubscriptionView (){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row (
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
            , horizontalArrangement = Arrangement.Center){
        Text(text = "Manage Subscription",
            fontWeight = FontWeight.Medium)
        }
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = 8.dp
        ){
            Column(
               verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(8.dp)
            ) {
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column {
                        Text(text = "Musical")
                        Text(text = "Free Trial")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("See All plans", color = Color.DarkGray)
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }
                }
                Divider()
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.baseline_account_box_24),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 4.dp))
                    Text(text = "Get a plan")
                }

            }
        }
    }
}