package chapter3_stacksAndQueues

import java.util.Stack

fun main(args: Array<String>){

    val myStack = MinStack()
    myStack.push(MinNode(3))
    myStack.push(MinNode(2))
    myStack.push(MinNode(4))
    myStack.push(MinNode(1))
    myStack.push(MinNode(5))
    myStack.push(MinNode(3))

    myStack.toArray().reversedArray().forEach {
        (it as MinNode).print()
    }
}

class MinStack(): Stack<MinNode>() {
    override fun push(item: MinNode): MinNode {
        item.min =
            if(this.isNotEmpty() && item.value > peek().min!!) {
                peek().min
            } else {
                item.value
            }

        return super.push(item)
    }

    public fun printTopDown(){
       this.toArray().reversedArray().forEach {
           (it as MinNode).print()
       }
    }
}

data class MinNode(val value: Int, ) {
    var min: Int? = null

    public fun print(){
        println("$value $min")
    }
}