package `in`.action.chap03

import `in`.action.util.joinToString
import `in`.action.chap03.lastChar as last // as : 임포트한 클래스나 함수를 다른 이름으로 부를 수 있음.

fun main() {
    val set = hashSetOf(1, 7, 53)

    set.forEach { println(it) }

    val list = arrayListOf(1, 7, 53)

    list.forEach { println(it) }

    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    map.entries.forEach { println("${it.key} -> ${it.value}") }

    println(set.javaClass) // javaClass == java getClass()

    println(list.javaClass)

    println(map.javaClass)

    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())

    val numbers = setOf(1, 14, 2)
    println(numbers.max())

    println(joinToString(list, "; ", "(", ")"))

    println(joinToString(list, separator = "; ", prefix = "(", postfix = ")"))

    println(joinToString(list))
    println(joinToString(list, "; "))

    println(joinToString(list, postfix = "/", prefix = "*"))

    //println("Kotlin".lastChar())
    println("Kotlin".last())

}

/*
확장함수
- String : 수신 객체 타입
- 확장 함수가 호출되는 대상이 되는 값(객체) : 수신 객체

private, protect 맴버는 사용 불가 = 캡슐화를 깨지는 않음
 */
//fun String.lastChar() : Char = this.get(this.length - 1)
fun String.lastChar(): Char = get(length -1) // 수신 객체 맴버에는 this 없이 접근 가능