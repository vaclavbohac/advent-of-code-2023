package com.vaclavbohac.advent2023.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TrebuchetTest {
    @Test
    fun `test sum calibrated values`() {
        val trebuchet = Trebuchet(listOf("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"))

        assertThat(trebuchet.sumCalibratedValues()).isEqualTo(142)
    }

    @Test
    fun `test sum calibrated values after interpolation`() {
        val trebuchet = Trebuchet(listOf("two1nine", "eightwothree", "abcone2threexyz", "xtwone3four", "4nineeightseven2", "zoneight234", "7pqrstsixteen"))

        assertThat(trebuchet.sumCalibratedValuesAfterInterpolation()).isEqualTo(281)
    }
}