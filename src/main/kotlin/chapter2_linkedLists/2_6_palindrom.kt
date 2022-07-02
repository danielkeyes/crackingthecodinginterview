package chapter2_linkedLists

import reusable.println

fun main(args: Array<String>) {
    solution(node = createLinkedList(listOf(1,4,2,4,2,4,1))).toString().println()
    solution(node = createLinkedList(listOf(1,4,2,4,2,2,1))).toString().println()
    solution(node = createLinkedList(listOf(1))).toString().println()
    solution(node = createLinkedList(listOf(1,2))).toString().println()
    solution(node = createLinkedList(listOf(1,2,2,1))).toString().println()
    solution(node = createLinkedList(listOf(1,2,2,1))).toString().println()
}

private fun solution(node: Node<Int>?): Boolean{
    if (node == null) { // size < 2
        return true
    }

    var newNode = Node(node.value, null)
    var currentNode = node.next

    var size = 1

    while (currentNode != null){
        val tempNode = Node(currentNode.value, newNode)
        newNode = tempNode
        size++
        currentNode = currentNode.next
    }

    currentNode = node
    for(i in 1 .. size/2){
        if(newNode.value != currentNode?.value){
            return false
        }
        newNode = newNode.next!!
        currentNode = currentNode?.next
    }

    return true
}