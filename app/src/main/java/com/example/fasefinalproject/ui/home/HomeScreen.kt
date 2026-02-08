package com.example.fasefinalproject.ui.home


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController



@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val contacts by viewModel.contacts.collectAsState(initial = emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.importContacts() }) {
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Importar")
            }
        }
    ) { padding ->

        LazyColumn(modifier = Modifier.padding(padding)) {

            items(
                items = contacts,
                key = { it.id }
            ) { contact ->

                ContactItem(contact) {
                    navController.navigate("detail/${contact.id}")
                }
            }
        }
    }
}


