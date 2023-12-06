package com.vaclavbohac.advent2023.day6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WaitForItTest {
    @Test
    fun getProductOfPossibleVictories() {
        val waitForIt = WaitForIt(lines)

        assertThat(waitForIt.getProductOfPossibleVictories()).isEqualTo(288)
    }

    @Test
    fun getPossibleVictoriesForCombinedInput() {
        val waitForIt = WaitForIt(lines)

        assertThat(waitForIt.getPossibleVictoriesForCombinedInput()).isEqualTo(71503)
    }

    companion object {
        val lines = listOf(
            "Time:      7  15   30",
            "Distance:  9  40  200"
        )
    }
}