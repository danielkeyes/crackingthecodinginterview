package chapter2_linkedLists

import reusable.println

fun main(args: Array<String>) {
    val linkedList1 = createLinkedList(listOf(1,4,2,6))
    val linkedList2 = createLinkedList(listOf(3,1,9))
    val linkedList3 = createLinkedList(listOf(2,1,9,4,3,1,2))

    linkedList1?.lastNode()?.next = linkedList3
    linkedList2?.lastNode()?.next = linkedList3

    solution(linkedList1, linkedList2)?.value.toString().println()
    solution2(linkedList1, linkedList2)?.value.toString().println()
}

private fun solution2(list1: Node<Int>?, list2: Node<Int>?):Node<Int>? {
    var list1Size = list1.size()
    var list2Size = list2.size()

    //On
    var list1CurrentPosition = list1
    var list2CurrentPosition = list2

    // get the list to the same size
    while (list1Size > list2Size) {
        list1CurrentPosition = list1CurrentPosition?.next
        list1Size--
    }
    while (list2Size > list1Size) {
        list2CurrentPosition = list2CurrentPosition?.next
        list2Size--
    }

    //On
    while(list1CurrentPosition!=null){
        if(list1CurrentPosition === list2CurrentPosition) {
            return list1CurrentPosition
        } else {
            list1CurrentPosition = list1CurrentPosition.next
            list2CurrentPosition = list2CurrentPosition?.next
        }
    }

    return null
}


private fun solution(list1: Node<Int>?, list2: Node<Int>?):Node<Int>? {
    var list1CurrentPosition = list1
    var list2CurrentPosition = list2

    while(list1CurrentPosition != null) {

        while(list2CurrentPosition != null) {
            if(list1CurrentPosition === list2CurrentPosition) {
                return list1CurrentPosition
            }
            list2CurrentPosition = list2CurrentPosition.next
        }
        list2CurrentPosition = list2

        list1CurrentPosition = list1CurrentPosition.next
    }

    return null
}