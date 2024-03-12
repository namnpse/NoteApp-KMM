package com.namnpse.noteapp_kmp.android.note_list

import com.namnpse.noteapp_kmp.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchedText: String = "",
    val isSearchShown: Boolean = false
)
