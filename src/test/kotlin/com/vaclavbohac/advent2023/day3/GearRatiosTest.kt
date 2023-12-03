package com.vaclavbohac.advent2023.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GearRatiosTest {
    @Test
    fun `get sum of all parts`() {
        val gearRatios = GearRatios(lines)

        assertThat(gearRatios.getSumOfAllParts()).isEqualTo(4361)
    }

    @Test
    fun `get sum of all gears`() {
        val gearRatios = GearRatios(lines)

        assertThat(gearRatios.getSumOfGears()).isEqualTo(467835)
    }

    companion object {
        val lines = listOf(
            "467..114.#",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            ".......755",
            "...$..*...",
            ".664#598.."
        )
    }
}