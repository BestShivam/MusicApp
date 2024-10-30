package com.example.musicapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties


@Composable
fun accountDialog (dialog: MutableState<Boolean>){
    if (dialog.value){
        AlertDialog(onDismissRequest = { dialog.value = false},
            confirmButton = {
                TextButton(onClick = { dialog.value = false }) {
                    Text(text = "Confirm", color = MaterialTheme.colorScheme.primary)
                }
            },
            dismissButton = {
                TextButton(onClick = { dialog.value = false }) {
                    Text(text = "Cancel", color = MaterialTheme.colorScheme.primary)
                }
            },
            title = {
                Text(text = "Add Account", color = MaterialTheme.colorScheme.secondary)
            },
            text = {
                Column {
                    TextField(value = "", onValueChange = {}, label = {
                        Text(text = "Email", color = MaterialTheme.colorScheme.secondary)
                    })
                    TextField(value = "", onValueChange = {},
                        label = {
                            Text(text = "Password", color = MaterialTheme.colorScheme.secondary)
                        })
                }
            },
            modifier = Modifier.padding(8.dp)
                .background(MaterialTheme.colorScheme.secondaryContainer)
            ,
            shape = RoundedCornerShape(8.dp),

            properties = DialogProperties(
                dismissOnClickOutside = true,
                dismissOnBackPress = true
            ),
        )
    }

}

