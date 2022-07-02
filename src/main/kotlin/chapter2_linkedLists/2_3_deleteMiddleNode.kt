package chapter2_linkedLists

import reusable.println

fun main(args: Array<String>) {
    val knowFirstNode = createLinkedList(10)
    solution(knowFirstNode, knowFirstNode)

    val knowLastNode = createLinkedList(5)
    createLinkedList()?.next?.next?.next?.next = Node(6, null)
    solution(knowLastNode, Node(6, null))

    val knowMiddleNode = createLinkedList(4)
    val middleNode = Node(value = 12, next = createLinkedList(4))
    knowMiddleNode?.next?.next?.next = middleNode
    solution(knowMiddleNode, middleNode)
}

private fun <T> solution(node: Node<T>?, deleteNode: Node<T>?){
    node?.printLinkedList()
    var myNode = node
    while (myNode?.next != null && myNode.next != deleteNode){
        myNode = myNode.next
    }
    if(myNode != null && myNode?.next?.next != null){
        myNode.next = myNode?.next?.next
    }
    node?.printLinkedList()
}