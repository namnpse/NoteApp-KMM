package com.namnpse.noteapp_kmp.android.detailed_note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun NoteDetailScreen(
    noteId: Long,
    navController: NavController,
    viewModel: NoteDetailViewModel = hiltViewModel()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                backgroundColor = Color.Black
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save note",
                    tint = Color.White
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

        }
    }
}