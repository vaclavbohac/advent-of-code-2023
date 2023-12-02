package com.vaclavbohac.advent2023.day2

import com.vaclavbohac.advent2023.day1.DiceColor
import com.vaclavbohac.advent2023.day1.Game

class CubeConundrum(private val lines: List<String>) {
    fun getPossibleGameIdsSum(): Int = lines
        .map { line -> parseGame(line) }
        .filter { game -> game.isValid() }
        .fold(0) { sum, game -> sum + game.id.toInt() }

    fun getSumOfPowersOfMinCubesRequired(): Int = lines
        .map { line -> parseGame(line) }
        .map { game -> game.getMinCubesRequired() }
        .map { cubes -> cubes.values.fold(1) { pow, count -> pow * count } }
        .fold(0) { sum, power -> sum + power }


    private fun parseGame(line: String): Game {
        val (name, rest) = line.split(": ")

        val (_, id) = name.split(" ")

        val turns = rest.split("; ").map { turn ->
            val map: MutableMap<DiceColor, Int> = mutableMapOf()

            turn.split(", ").forEach { dice ->
                val (number, color) = dice.split(" ")

                map[color.toDiceColor()] = number.toInt()
            }

            map
        }

        return Game(id, turns)
    }
}

private fun String.toDiceColor(): DiceColor = DiceColor.valueOf(this.uppercase())