package com.namnpse.noteapp_kmp.data.local

import com.namnpse.noteapp_kmp.data.mappers.toNote
import com.namnpse.noteapp_kmp.db.NoteDatabase
import com.namnpse.noteapp_kmp.domain.note.Note
import com.namnpse.noteapp_kmp.domain.note.NoteDataSource
import com.namnpse.noteapp_kmp.domain.utils.DateTimeUtil

class SqlDelightNoteDataSource(db: NoteDatabase) : NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            type = note.type,
            hexColor = note.hexColor,
            createdAt = DateTimeUtil.toEpochMillis(note.createdAt)
        )
    }

    override suspend fun getNoteById(noteId: Long): Note? {
        return queries
            .getNoteById(noteId)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries
            .getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(noteId: Long) {
        queries.deleteNoteById(noteId)
    }
}