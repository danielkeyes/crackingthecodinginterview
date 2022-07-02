package chapter2_linkedLists

fun main(args: Array<String>) {

    solution(node = createLinkedList(listOf(5,2,9,7,2,5)), 4)?.printLinkedList()
    solution(node = createLinkedList(listOf(5,2,9,7,2,5)), 1)?.printLinkedList()
    solution(node = createLinkedList(listOf(5,2,9,7,2,5,9,10)), 7)?.printLinkedList()
}

private fun solution(node: Node<Int>?, value: Int): Node<Int>?{
    node?.printLinkedList()
    var currentNode = node

    var tip = node
    var tail = node

    while(currentNode != null){
        val nextNode = currentNode.next

        if(currentNode.value < value) { //if less, add to tip
            currentNode.next = tip
            tip = currentNode
        } else { // else add to tail
            tail?.next = currentNode
            tail = currentNode
        }
        currentNode = nextNode // move to next next
    }
    tail?.next = null // close out my linked list

    return tip
}