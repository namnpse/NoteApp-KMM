package com.namnpse.noteapp_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform