package chapter3_stacksAndQueues

import reusable.println
import java.util.*

fun main(args: Array<String>){

    val myStack = Stack<Int>()
    
    myStack.push(1)
    myStack.push(4)
    myStack.push(9)
    myStack.push(3)
    myStack.push(2)
    myStack.push(5)

    myStack.sortMinStack()

    while (!myStack.isEmpty()){
        myStack.pop().toString().println()
    }
}

fun Stack<Int>.sortMinStack(): Stack<Int> {
    val tempStack = Stack<Int>()
    
    var size =0
    
    while (!this.isEmpty()) { //move them to get size
        tempStack.push(this.pop())
        size++
    }
    transfer(intoStack = this, outOfStack = tempStack) // move them back

    while(size > 0){
        var largest = this.pop()
        var count = 0

        // Get our largest, everything else in tempstack
        while (this.notEmpty() && count < size){ 0<6
            if(this.peek() > largest) {
                tempStack.push(largest)
                largest = this.pop()
            } else {
                tempStack.push(this.pop())
            }
            count ++
        }

        // push largest in first
        this.push(largest)

        // move everything from temp stack into mystack on top
        transfer(intoStack = this, outOfStack = tempStack)

        size--
    }

    return this
}

// TODO kdoc me
fun transfer(intoStack: Stack<Int>, outOfStack: Stack<Int>){
    while(!outOfStack.isEmpty()){
        intoStack.push(outOfStack.pop())
    }
}

fun Stack<Int>.notEmpty() = !this.isEmpty()