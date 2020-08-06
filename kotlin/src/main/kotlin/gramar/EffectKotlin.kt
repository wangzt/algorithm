package gramar

import kotlin.system.measureNanoTime

/**
 *
 * Created by wangzhitao on 2020/08/05
 *
 **/
fun testSequence() {
    val sequence = generateSequence(1) {it + 1}.take(500000)
    val list = sequence.toList()

    println("List Map sum     = "
            + measureNanoTime { list.map { it * 2 }.sum() })

    println("Sequence Map sum = "
            + measureNanoTime { sequence.map { it * 2 }.sum() })

    println("List Map average = "
            + measureNanoTime { list.map { it * 2 }.average() })

    println("Seq Map average  = "
            + measureNanoTime { sequence.map{ it * 2}.average() })
}

fun testMap() {
    arrayOf(1, 2, 3).map { i: Int -> i * 10 }.forEach(::println)
}

fun testJoinToString() {
    val result1 = arrayOf("a", "b", "c", "d").joinToString { i -> i }
    val result2 = arrayOf("a", "b", "c", "d").joinToString (separator = "#", prefix = "[前缀]", postfix = "[后缀]", limit = 3, truncated = "[省略号]") { i -> i }
    println(result1)
    println(result2)
    arrayOf(4, 3, 2, 5).takeWhile { i -> i > 2 }.forEach(::println)
    arrayOf(4, 3, 2, 5).filter { i -> i > 2 }.forEach(::println)
}
