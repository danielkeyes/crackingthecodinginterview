package chapter2_linkedLists

import reusable.println

fun main(args: Array<String>){
    val node = createLinkedList(listOf(1,5,2,3,5))
    val repeatingNode = createLinkedList(listOf(9,4,2,1))
    repeatingNode?.lastNode()?.next = repeatingNode
    node?.lastNode()?.next = repeatingNode

    solution(node)?.value.toString().println()
}

// On^2
private fun solution(node: Node<Int>?): Node<Int>?{
    var currentPositionIndex = 2
    var currentPosition = node?.next

    while (true){ //guaranteed to have repeating node, no worry with edge cases
        var searchPosition = node // start search from first node
        repeat(currentPositionIndex-1){// traverse through all nodes but current position
            if (currentPosition === searchPosition){
                return currentPosition
            }
            searchPosition = searchPosition?.next
        }
        currentPosition = currentPosition?.next
        currentPositionIndex++
    }
}