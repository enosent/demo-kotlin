package demo.stream

fun main() {

    val myList = listOf("a1", "a2", "b1", "c2", "c1")

    myList
        .asSequence()
        .filter { it.startsWith("c") }
        .map { it.toUpperCase() }
        .forEach(::println)

    hr()


    listOf("a1", "a2", "a3")
        .asSequence()
        .firstOrNull()
        .apply(::println)

    hr()

    (1..4).asSequence()
        .forEach(::println)

    hr()

    sequenceOf(1.0, 2.0, 3.0)
        .map { "a" + it.toInt() }
        .forEach(::println)

    hr()

    sequenceOf("d2", "a2", "b1", "b3", "c")
        .filter {
            println("filter: $it")
            true
        }
        .forEach { println("forEach: $it") }

    hr()

    sequenceOf("d2", "a2", "b1", "a3", "c")
        .map {
            println("map: $it")
            it.toUpperCase()
        }
        .any {
            println("match: $it")
            it.startsWith("A")
        }

    hr()

    sequenceOf("d2", "a2", "b1", "a3", "c")
        .map {
            println("map: $it")
            it.toUpperCase()
        }
        .filter {
            println("match: $it")
            it.startsWith("A")
        }
        .forEach { println("forEach: $it") }

    hr()

    sequenceOf("d2", "a2", "b1", "a3", "c")
        .filter {
            println("match: $it")
            it.startsWith("a")
        }
        .map {
            println("map: $it")
            it.toUpperCase()
        }
        .forEach { println("forEach: $it") }

    hr()

    sequenceOf("d2", "a2", "b1", "a3", "c")
        .sorted()
        .filter {
            println("match: $it")
            it.startsWith("a")
        }
        .map {
            println("map: $it")
            it.toUpperCase()
        }
        .forEach { println("forEach: $it") }

    hr()

    sequenceOf("d2", "a2", "b1", "a1", "c")
        .filter {
            println("match: $it")
            it.startsWith("a")
        }
        .sorted()
        .map {
            println("map: $it")
            it.toUpperCase()
        }
        .forEach { println("forEach: $it") }

}

fun hr() {
    println("============================================================================")
}