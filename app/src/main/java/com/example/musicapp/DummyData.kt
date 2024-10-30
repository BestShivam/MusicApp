package com.example.musicapp

import androidx.annotation.DrawableRes


data class Lib(
    @DrawableRes val icon: Int,
    val name : String)

val liberaryItem = listOf<Lib>(
    Lib(R.drawable.ic_playlist_green,"Playlist"),
    Lib(R.drawable.ic_microphone,"Artists"),
    Lib(R.drawable.ic_baseline_album_24,"Album"),
    Lib(R.drawable.ic_baseline_music_note_24,"Songs"),
    Lib(R.drawable.ic_genre,"Genre"),
)