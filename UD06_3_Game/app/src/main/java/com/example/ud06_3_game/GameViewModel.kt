package com.example.ud06_3_game

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    val words = listOf("Calamar", "Android", "Caballo", "Despiste", "Sabela", "Error")
    var targetWord = words.random().uppercase()
    var targetWordHidden = ""
    var lives = 7
    var attempts = mutableListOf<Char>()
    init {
    // Inicializamos la palabra con _
        targetWordHidden = showTargetWordHidden(' ')
    }
    //Genera la representación visual
    fun showTargetWordHidden(charAttempt: Char) =
        targetWord.map {
            if(it == charAttempt.toUpperCase()) it
            else '_'
        }.joinToString(" ")

    //Jugar
    fun guess(charAttempt : Char){
        targetWordHidden = showTargetWordHidden(charAttempt)
        if (!targetWord.contains(charAttempt)) lives -= 1
    }

    fun win() = targetWord == targetWordHidden
    fun lost() = lives <= 0
}