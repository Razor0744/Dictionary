package com.example.dictionary.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val english: String,
    val russian: String,
    val daysWithoutMistakes: Int = 0
)
