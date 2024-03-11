package com.namnpse.noteapp_kmp.android.di

import android.app.Application
import com.namnpse.noteapp_kmp.data.local.NoteDatabaseDriverFactory
import com.namnpse.noteapp_kmp.data.local.SqlDelightNoteDataSource
import com.namnpse.noteapp_kmp.db.NoteDatabase
import com.namnpse.noteapp_kmp.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return NoteDatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }
}