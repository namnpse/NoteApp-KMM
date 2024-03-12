package com.namnpse.noteapp_kmp.android.note_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.namnpse.noteapp_kmp.domain.note.SearchNotesUseCase
import com.namnpse.noteapp_kmp.domain.note.Note
import com.namnpse.noteapp_kmp.domain.note.NoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val noteDataSource: NoteDataSource,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val searchNotes = SearchNotesUseCase()

    private val notes = savedStateHandle.getStateFlow("notes", emptyList<Note>())
    private val searchedText = savedStateHandle.getStateFlow("searchedText", "")
    private val isSearchShown = savedStateHandle.getStateFlow("isSearchShown", false)

    val state = combine(notes, searchedText, isSearchShown) { notes, searchedText, isSearchShown ->
        NoteListState(
            notes = searchNotes.execute(notes, searchedText),
            searchedText = searchedText,
            isSearchShown = isSearchShown
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteListState())

    fun getNotes() {
        viewModelScope.launch {
            savedStateHandle["notes"] = noteDataSource.getAllNotes()
        }
    }

    fun onSearchTextChange(text: String) {
        savedStateHandle["searchText"] = text
    }

    fun onToggleSearch() {
        savedStateHandle["isSearchActive"] = !isSearchShown.value
        if(isSearchShown.value.not()) {
            savedStateHandle["searchText"] = ""
        }
    }

    fun deleteNoteById(id: Long) {
        viewModelScope.launch {
            noteDataSource.deleteNoteById(id)
            getNotes()
        }
    }
}