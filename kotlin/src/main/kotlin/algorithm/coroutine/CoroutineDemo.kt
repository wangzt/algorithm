package algorithm.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *
 * Created by wangzhitao on 2020/07/23
 *
 **/

class CoroutineDemo {
    fun test() {
        baseTest()
    }

    private fun baseTest() {
        println("Coroutine init start, time: ${System.currentTimeMillis()}")

        GlobalScope.launch(Dispatchers.Main) {
            println("Coroutine init end, time: ${System.currentTimeMillis()} , thread: ${Thread.currentThread()}")
            for (i in 1..3) {
                println("Coroutine task 1 print $i, time: ${System.currentTimeMillis()}")
            }

            delay(500)

            for (i in 1..3) {
                println("Coroutine task 2 print $i, time: ${System.currentTimeMillis()}")
            }
        }

        println("Main thread sleep, time: ${System.currentTimeMillis()} , thread: ${Thread.currentThread()}")
        Thread.sleep(1000)
        println("Main thread run, time: ${System.currentTimeMillis()}")

        for (i in 1..3) {
            println("Main thread print $i, time: ${System.currentTimeMillis()}")
        }
    }
}