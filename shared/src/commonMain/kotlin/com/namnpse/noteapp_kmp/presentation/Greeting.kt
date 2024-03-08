package com.namnpse.noteapp_kmp.presentation

import com.namnpse.noteapp_kmp.Platform
import com.namnpse.noteapp_kmp.getPlatform

class Greeting {
    private val platform: Platform = getPlatform()

    fun greeting(): String {
        return "Hello, ${platform.name}!"
    }
}