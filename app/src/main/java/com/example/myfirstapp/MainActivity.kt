package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TodoApp()
        }
    }
}

@Composable
fun TodoApp() {

    var task by remember { mutableStateOf("") }
    var tasks by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "My To-Do List",
            style = MaterialTheme.typography.headlineMedium
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            OutlinedTextField(
                value = task,
                onValueChange = { task = it },
                label = { Text("Enter a task") },
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    if (task.isNotBlank()) {
                        tasks = tasks + task
                        task = ""
                    }
                }
            ) {
                Text("Add")
            }
        }

        LazyColumn(
            modifier = Modifier.padding(top = 20.dp)
        ) {

            items(tasks) { item ->

                Text(
                    text = "• $item",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}