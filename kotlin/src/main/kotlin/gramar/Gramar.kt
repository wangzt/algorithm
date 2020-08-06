package gramar

/**
 *
 * Created by wangzhitao on 2020/08/04
 *
 **/

// Lambda表达式
val max = {x: Int, y: Int -> if (x > y) x else y }

val max2:(Int, Int) -> Int = {x: Int, y: Int -> if (x > y) x else y}

val sum = {x: Int -> {y: Int -> x + y}}

// 带接收者的函数字面值
val sum2 = fun Int.(other: Int):Int = this + other

class HTML {

    fun head() {
        println("HTML HEAD")
    }
    fun body() {
        println("HTML BODY")
    }
}

fun html(init:HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}

fun testHtml() {
    html {
        head()
        body()
    }
}