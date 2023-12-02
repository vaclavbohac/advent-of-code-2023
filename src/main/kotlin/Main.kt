import com.vaclavbohac.advent2023.day1.Trebuchet
import com.vaclavbohac.advent2023.day2.CubeConundrum
import com.vaclavbohac.advent2023.puzzle.Puzzle
import java.io.File

fun main() {
    val puzzles =
        listOf(
            Trebuchet(File("src/main/resources/day-1-input.txt").readLines()).toPuzzle(),
            CubeConundrum(File("src/main/resources/day-2-input.txt").readLines()).toPuzzle()
        )

    puzzles.forEachIndexed { i, puzzle ->
        println("Day ${i + 1}. Puzzle: ${puzzle.name}")

        println("1st star solution: ${puzzle.firstStarSolution}")
        println("2nd star solution: ${puzzle.secondStarSolution}")
    }
}

private fun Trebuchet.toPuzzle(): Puzzle =
    Puzzle("Trebuchet", sumCalibratedValues().toString(), sumCalibratedValuesAfterInterpolation().toString())
private fun CubeConundrum.toPuzzle(): Puzzle =
    Puzzle("Cube Conundrum", getPossibleGameIdsSum().toString(), getSumOfPowersOfMinCubesRequired().toString())
