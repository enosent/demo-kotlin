package `in`.action.chap01

// `데이터` 클래스
data class Person(val name: String, val age: Int? = null) // null 값을 허용하는 Int 타입 age

// 최상위 함수
fun main() {

    val persons = listOf(
        Person("영희"),
        Person("철수", 29)
    )

    val oldest = persons.maxBy { it.age ?: 0 } // Elvis operator => null인 경우 0을 반환
    /*
        age 타입이 null 값을 허용하는 Int

        Elvis operator 사용을 안하는 경우 Compile Exception 발생

        Type parameter bound for R in
          inline fun <T, R : Comparable<R>> Iterable<T>.maxBy ( select: (T) -> R ): T?
        is not satisfied: inferred type `Int?` is not a subtype of Comparable<Int?>
     */
    println("나이가 가장 많은 사람: $oldest")

}