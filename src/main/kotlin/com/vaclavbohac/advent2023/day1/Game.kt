package com.vaclavbohac.advent2023.day1

enum class DiceColor {
    RED,
    GREEN,
    BLUE
}

data class Game(val id: String, val turns: List<Map<DiceColor, Int>>) {
    fun isValid(): Boolean = turns.all { turn ->
        turn.all { dice -> GAME_LIMITS[dice.key]?.let { it >= dice.value } ?: false }
    }

    fun getMinCubesRequired(): Map<DiceColor, Int> = DiceColor.values().associateWith { color ->
        turns.mapNotNull { turn -> turn[color] }.max()
    }

    companion object {
        val GAME_LIMITS: Map<DiceColor, Int> = mapOf(DiceColor.RED to 12, DiceColor.GREEN to 13, DiceColor.BLUE to 14)
    }
}
