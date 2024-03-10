package com.namnpse.noteapp_kmp.data.mappers

import com.namnpse.noteapp_kmp.domain.note.Note
import db.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        type = type,
        hexColor = hexColor,
        createdAt = Instant
            .fromEpochMilliseconds(createdAt)
            .toLocalDateTime(TimeZone.currentSystemDefault())
    )
}