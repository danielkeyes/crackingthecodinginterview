package chapter2_linkedLists

import reusable.println

fun main(args: Array<String>) {
    solution(createLinkedList(10),4)?.value.toString().println()
    solution(createLinkedList(2),4)?.value.toString().println()
    solution(createLinkedList(4),2)?.value.toString().println()
}

private fun <T>solution(node: Node<T>?, k: Int): Node<T>?{
    node?.printLinkedList()
    var kthNode: Node<T>? = null //firstNode
    var sn: Node<T>? = node //searchNode

    var count = 1

    // get to k+1 node
    while(sn != null && count<=k){
        sn = sn.next
        count++
    }

    if (sn == null){
        return null
    } else {
        kthNode = node
        while (sn?.next != null) {//not at last node
            sn = sn.next
            kthNode = kthNode?.next
        }
    }

    return kthNode
}