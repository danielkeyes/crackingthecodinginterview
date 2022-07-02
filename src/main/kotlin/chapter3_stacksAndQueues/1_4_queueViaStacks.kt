package chapter3_stacksAndQueues

import reusable.println
import java.util.*

fun main(args: Array<String>){
    val myQueue = MyQueue()

    myQueue.push(3)
    myQueue.push(2)
    myQueue.push(6)

    myQueue.pop().toString().println()
    myQueue.pop().toString().println()
    myQueue.pop().toString().println()
    myQueue.pop().toString().println()
    myQueue.push(6)
    myQueue.pop().toString().println()
}

class MyQueue(){
    private val newest = Stack<Int>()
    private val oldest = Stack<Int>()

    fun push(item: Int): Int? {
        return oldest.push(item)
    }

    fun pop(): Int? {
        if(newest.isEmpty()){
            while (oldest.isNotEmpty()){
                newest.push(oldest.pop())
            }
        }
        return if(newest.isEmpty()){
            return null
        } else {
            return newest.pop()
        }
    }
}

