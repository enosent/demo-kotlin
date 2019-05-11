package `in`.action.chap02

import `in`.action.chap02.Color.*

fun main() {

    println(Color.BLUE.rgb())

    println(getMnemonic(Color.BLUE))

    println(getWarmth(Color.ORANGE))

    println(mix(BLUE, YELLOW))
}

fun getMnemonic(color: Color) {
    when(color) {
        RED -> "Richard"
        ORANGE -> "Of"
        YELLOW -> "York"
        GREEN -> "Gave"
        BLUE -> "Battle"
        INDIGO -> "In"
        VIOLET -> "Vain"
    }
}

fun getWarmth(color: Color) = when(color) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}

fun mix(c1: Color, c2: Color) =
    when(setOf(c1, c2)) { // setOf => Kotlin에서 set collection 만드는 함수
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color") // else가 없으면 compile exception
    }


// enum 선언 방식
enum class Color(  val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238); // `;` 반드시 있어야 함

    fun rgb() = (r*256 + g) * 256 + b
}