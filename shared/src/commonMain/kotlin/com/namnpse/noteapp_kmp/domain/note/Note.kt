package com.namnpse.noteapp_kmp.domain.note

import com.namnpse.noteapp_kmp.presentation.*
import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val type: String,
    val hexColor: Long,
    val createdAt: LocalDateTime
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, LightGreenHex, BabyBlueHex, VioletHex)

        fun getRandomColor() = colors.random()
    }
}
