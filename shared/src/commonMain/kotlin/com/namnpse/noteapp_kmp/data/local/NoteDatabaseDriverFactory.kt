package com.namnpse.noteapp_kmp.data.local

import com.squareup.sqldelight.db.SqlDriver

expect class NoteDatabaseDriverFactory {
    fun createDriver(): SqlDriver
}