package chapter2_linkedLists.`2`

import chapter2_linkedLists.Node
import chapter2_linkedLists.createLinkedList
import chapter2_linkedLists.printLinkedList
import reusable.println
import kotlin.math.pow

fun main(args: Array<String>) {
    val first = createLinkedList(listOf(7,1,6))?.toReverseInteger() ?: 0
    val second = createLinkedList(listOf(5,9,2))?.toReverseInteger() ?: 0

    (first+second).toReverseNode()?.printLinkedList()

    val first2 = createLinkedList(listOf(7,1,6))?.toInteger() ?: 0
    val second2 = createLinkedList(listOf(5,9,2))?.toInteger() ?: 0

    first2.toString().println()
    second2.toString().println()
    (first2+second2).toNode()?.printLinkedList()
}

private fun solution(node: Node<Int>){

}

private fun Node<Int>.toReverseInteger(): Int {
    var currentPos: Node<Int>? = this

    var value = 0
    var count = 0

    while(currentPos != null) {
        value += currentPos.value * 10.0.pow(count.toDouble()).toInt()
        currentPos = currentPos.next
        count++
    }

    return value
}

private fun Int.toReverseNode(): Node<Int>? {
    var myInteger = this

    var firstNode = Node(myInteger%10) //set up first node
    myInteger /= 10

    var currentNode = firstNode // create pointer node


    while(myInteger>0){
        currentNode.next = Node(myInteger%10)
        myInteger /= 10
        currentNode = currentNode.next!!
    }

    return firstNode
}
private fun Node<Int>.toInteger(): Int {
    var currentPos: Node<Int>? = this

    var value = 0

    while(currentPos != null) {
        value = value*10 + currentPos.value
        currentPos = currentPos.next
    }

    return value
}

private fun Int.toNode(): Node<Int>? {
    var myInteger = this.toString()

    var firstNode = Node(myInteger[0].toInt() - '0'.code) //set up first node

    var currentNode = firstNode // create pointer node

    for(i in 1 until myInteger.length) {
        currentNode.next = Node(myInteger[i].toInt() - '0'.code)
        currentNode = currentNode.next!!
    }

    return firstNode
}
