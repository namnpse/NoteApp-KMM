package com.namnpse.noteapp_kmp.domain.note

interface NoteDataSource {

    suspend fun insertNote(note: Note)

    suspend fun getAllNotes(): List<Note>

    suspend fun getNoteById(noteId: Long): Note?

    suspend fun deleteNoteById(noteId: Long)
}