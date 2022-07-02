package chapter2_linkedLists

import java.util.LinkedList
import kotlin.random.Random


fun main(args: Array<String>){
    createLinkedList(5)?.printLinkedList()

    var linkedList = LinkedList<Int>(listOf(1,2,3))

}

data class Node<T>(val value: T, var next: Node<T>? = null)

fun Node<Int>.lastNode(): Node<Int>{
    var currentNode = this

    while(currentNode.next != null) {
        currentNode = currentNode.next!!
    }

    return currentNode
}

fun Node<Int>?.size(): Int{
    var currentNode: Node<Int>? = this

    var count = 0

    while(currentNode != null) {
       count ++
       currentNode = currentNode.next
    }

    return count
}

fun createLinkedList(list: List<Int>): Node<Int>?{
    var firstNode: Node<Int>? = null

    if(list.isNotEmpty()){
        firstNode = Node(list[0])

        var currentNode = firstNode

        list.subList(1,list.size).forEach {
            currentNode?.next = Node(it)
            currentNode = currentNode?.next
        }
    }
    return firstNode
}

fun createLinkedList(size: Int = 0): Node<Int>?{
    if(size<=0){
        return null
    }

    var firstNode: Node<Int> = Node(Random.nextInt()%25)
    var totalElements = 1

    while(size-totalElements > 0){
        firstNode = Node(Random.nextInt()%25, firstNode)
        totalElements++
    }

    return firstNode
}

fun <T> Node<T>.printLinkedList(){
    var currentNode = this
    val sb = StringBuilder()

    sb.append("${currentNode.value}")

    while(currentNode.next != null) {
        currentNode = currentNode.next!!
        sb.append(" -> ${currentNode.value}")
    }

    println(sb.toString())
}