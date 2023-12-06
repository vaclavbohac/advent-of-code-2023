import com.vaclavbohac.advent2023.day1.Trebuchet
import com.vaclavbohac.advent2023.day2.CubeConundrum
import com.vaclavbohac.advent2023.day3.GearRatios
import com.vaclavbohac.advent2023.day4.Scratchcards
import com.vaclavbohac.advent2023.puzzle.Puzzle
import java.io.File

fun main() {
    val puzzles =
        listOf(
            Trebuchet(File("src/main/resources/day-1-input.txt").readLines()).toPuzzle(),
            CubeConundrum(File("src/main/resources/day-2-input.txt").readLines()).toPuzzle(),
            GearRatios(File("src/main/resources/day-3-input.txt").readLines()).toPuzzle(),
            Scratchcards(File("src/main/resources/day-4-input.txt").readLines()).toPuzzle()
        )

    puzzles.forEachIndexed { i, puzzle ->
        println("Day ${i + 1}. Puzzle: ${puzzle.name}")

        println("1st star solution: ${puzzle.firstStarSolution}")
        println("2nd star solution: ${puzzle.secondStarSolution}")
    }
}

private fun Trebuchet.toPuzzle(): Puzzle =
    Puzzle("Trebuchet", sumCalibratedValues(), sumCalibratedValuesAfterInterpolation())
private fun CubeConundrum.toPuzzle(): Puzzle =
    Puzzle("Cube Conundrum", getPossibleGameIdsSum(), getSumOfPowersOfMinCubesRequired())
private fun GearRatios.toPuzzle(): Puzzle = Puzzle("Gear Ratios", getSumOfAllParts(), getSumOfGears())
private fun Scratchcards.toPuzzle(): Puzzle = Puzzle("Scratchcards", getTotalPoints(), getScratchcardsCount())
