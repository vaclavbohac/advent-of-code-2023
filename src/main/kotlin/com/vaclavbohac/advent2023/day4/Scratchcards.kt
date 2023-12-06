package com.vaclavbohac.advent2023.day4

class Scratchcards(private val lines: List<String>) {
    fun getTotalPoints(): Int {
        var totalScore = 0

        for (line in lines) {
           val winningsNumbers = getWinningNumbers(line)

            var score = 0
            var i = 0
            while (i < winningsNumbers.size) {
                if (i == 0) {
                    score += 1
                } else {
                    score *= 2
                }

                i += 1
            }

            totalScore += score
        }

        return totalScore
    }

    fun getScratchcardsCount(): Int {
        val cards = Array(lines.size) { 1 }

        for (cardIndex in cards.indices) {
            val line = lines[cardIndex]

            val winningNumbers = getWinningNumbers(line)

            for (i in cardIndex + 1 until cardIndex + 1 + winningNumbers.size) {
                cards[i] += cards[cardIndex]
            }
        }

        return cards.sum()
    }

    private fun getWinningNumbers(line: String): Set<String> {
        val (_, numbers) = line.split(": ")

        val (sectionA, sectionB) = numbers.split(" | ")

        val winningNumbers = sectionA.split(' ').filter { s -> s !== "" }.toSet()
        val betNumbers = sectionB.split(' ').filter { s -> s !== "" }.toSet()

        return winningNumbers.intersect(betNumbers)
    }
}