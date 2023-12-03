package com.vaclavbohac.advent2023.day3

class GearRatios(private val lines: List<String>) {
    fun getSumOfAllParts(): Int {
        val validNumbers = mutableListOf<Int>()

        lines.forEachIndexed { i, line ->
            var j = 0
            var number = StringBuffer()
            var indexStart = 0

            while (j < line.length) {
                if (line[j].isDigit()) {
                    if (number.isEmpty()) {
                        indexStart = j
                    }

                    number.append(line[j])
                }

                if (number.isNotEmpty() && (!line[j].isDigit() || j == line.length - 1)) {

                    if (isValidNumber(indexStart, j - 1, i)) {
                        validNumbers.add(number.toString().toInt())
                    }

                    number = StringBuffer()
                }

                j += 1
            }
        }

        return validNumbers.sum()
    }

    fun getSumOfGears(): Int {
        val stars: MutableMap<Pair<Int, Int>, MutableList<Int>> = mutableMapOf()

        lines.forEachIndexed { i, line ->
            var j = 0
            var number = StringBuffer()
            var indexStart = 0

            while (j < line.length) {
                if (line[j].isDigit()) {
                    if (number.isEmpty()) {
                        indexStart = j
                    }

                    number.append(line[j])
                }

                if (number.isNotEmpty() && (!line[j].isDigit() || j == line.length - 1)) {
                    val num = number.toString().toInt()
                    val star = getAdjacentStar(indexStart, j - 1, i)

                    if (star != null) {
                        if (stars[star].isNullOrEmpty()) {
                            stars[star] = mutableListOf(num)
                        } else {
                            stars[star]?.add(num)
                        }
                    }

                    number = StringBuffer()
                }

                j += 1
            }
        }

        return stars
            .filter { star -> star.value.size == 2 }
            .map { star -> star.value.fold(1) { prod, num -> prod * num } }
            .sum()
    }


    private fun isValidNumber(start: Int, end: Int, line: Int): Boolean {
        val columnRange = maxOf(start - 1, 0).rangeTo(minOf(end + 1, lines[0].length))
        val rowRange = maxOf(line - 1, 0).rangeTo(minOf(line + 1, lines.size - 1))

        for (i in columnRange) {
            for (j in rowRange) {
                val c = lines[j][i]

                if (!c.isDigit() && c != '.') {
                    return true
                }
            }
        }

        return false
    }

    private fun getAdjacentStar(start: Int, end: Int, line: Int): Pair<Int, Int>? {
        val columnRange = maxOf(start - 1, 0).rangeTo(minOf(end + 1, lines[0].length))
        val rowRange = maxOf(line - 1, 0).rangeTo(minOf(line + 1, lines.size - 1))

        for (i in columnRange) {
            for (j in rowRange) {
                val c = lines[j][i]

                if (c == '*') {
                    return Pair(j, i)
                }
            }
        }

        return null
    }
}