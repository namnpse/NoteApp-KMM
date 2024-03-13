package com.namnpse.noteapp_kmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.namnpse.noteapp_kmp.android.detailed_note.NoteDetailScreen
import com.namnpse.noteapp_kmp.android.note_list.NoteListScreen
import com.namnpse.noteapp_kmp.android.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "note_list") {

                    composable(route = "note_list") {
                        NoteListScreen(navController = navController)
                    }

                    composable(
                        route = "note_detail/{noteId}",
                        arguments = listOf(
                            navArgument(name = "noteId") {
                                type = NavType.LongType
                                defaultValue = -1L
                            }
                        )
                    ) { backStackEntry ->
                        val noteId = backStackEntry.arguments?.getLong("noteId") ?: -1L
                        NoteDetailScreen(
                            navController = navController,
                            noteId = noteId,
                        )
                    }
                }
            }
        }
    }
}
