package chapter3_stacksAndQueues

import java.util.Stack

fun main(args: Array<String>) {
    val myStacks: SetOfStacks = SetOfStacks(2)

    myStacks.push(3)
    myStacks.push(2)
    myStacks.push(4)
    myStacks.push(5)
    myStacks.push(2)
    myStacks.push(6)
    myStacks.push(2)

    myStacks.printAll()

    myStacks.popAt(1)
    myStacks.popAt(1)
    myStacks.pop()

    println("--------------")
    myStacks.printAll()

}

class SetOfStacks(private var threshold: Int = 20){
    private val myStacks = arrayListOf<Stack<Int>>(Stack<Int>()) // initialize with single stack

    private val lastStackIndex
        get() = myStacks.size-1

    fun push(item: Int){
        if(myStacks[lastStackIndex].size >= threshold){
            myStacks.add(Stack<Int>())
        }
        myStacks[lastStackIndex].push(item)
    }

    private fun popFromIndex(index: Int): Int? {
        val returnValue =  myStacks[index].pop()

        if (myStacks[index].size<=0){ // if we popped the last item, we need to remove the stack
            myStacks.removeAt(index)
        }
        return returnValue
    }

    fun pop(): Int? {
        return popFromIndex(lastStackIndex)
    }

    fun popAt(index: Int): Int? {
        return  popFromIndex(index)
    }

    fun printAll(){
        println("")

        myStacks.forEachIndexed{ index, stack ->
            stack.forEach {
                println("stack:$it array:$index")
            }
        }
    }
}

