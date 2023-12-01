package com.vaclavbohac.advent2023.day1

class Trebuchet(private val lines: List<String>) {
    fun sumCalibratedValues(): Int =
        lines.fold(0) { sum, line -> sum + (line.getFirstDigit() * 10 + line.reversed().getFirstDigit()) }

    fun sumCalibratedValuesAfterInterpolation(): Int =
        lines.fold(0) { sum, line -> sum + (line.getFirstInterpolatedNumber(INTERPOLATION_TABLE) * 10 + line.getLastInterpolatedNumber(INTERPOLATION_TABLE)) }

    companion object {
        val INTERPOLATION_TABLE = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)
    }
}

private fun String.getFirstDigit(): Int = this.first { c -> c.isDigit() }.digitToInt()

private fun String.getFirstInterpolatedNumber(numbers: Map<String, Int>): Int {
    this.forEachIndexed { i, c ->
        if (c.isDigit()) {
            return c.digitToInt()
        }

        for (number in numbers) {
            if (this.startsWith(number.key, i)) {
                return number.value
            }
        }
    }

    return -1
}

private fun String.getLastInterpolatedNumber(numbers: Map<String, Int>): Int =
    this.reversed().getFirstInterpolatedNumber(numbers.mapKeys { it.key.reversed() } )
