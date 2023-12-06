package com.vaclavbohac.advent2023.day6

class WaitForIt(private val lines: List<String>) {
    fun getProductOfPossibleVictories(): Int {
        val times = lines[0].split(" ").filterNot { it == "" }.drop(1).map { it.toInt() }
        val distances = lines[1].split(" ").filterNot { it == "" }.drop(1).map { it.toInt() }

        return times.mapIndexed { index, time ->
            val distance = distances[index]

            var wins = 0
            for (i in 1 until time) {
                if ((time - i) * i > distance) {
                    wins += 1
                }
            }

            wins
        }.fold(1) { a, b -> a * b }
    }

    fun getPossibleVictoriesForCombinedInput(): Int {
        val time = lines[0].split(":")[1].replace(" ", "").toLong()
        val distance = lines[1].split(":")[1].replace(" ", "").toLong()

        var wins = 0
        for (i in 1 until time) {
            if ((time - i) * i > distance) {
                wins += 1
            }
        }

        return wins
    }
}