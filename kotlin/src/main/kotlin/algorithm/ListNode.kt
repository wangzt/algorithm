package algorithm

/**
 *
 * Created by wangzhitao on 2020/08/03
 *
 **/
class ListNode (var `val`: Int) {
    var next: ListNode? = null
}

class ListNodeTest {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var left = l1
        var right = l2
        var rootNode = ListNode(0)

        var currentNode = rootNode
        var carry = 0
        while (left != null || right != null || carry != 0) {
            var v1 = left?.`val` ?: 0
            var v2 = right?.`val` ?: 0
            var sum = v1 + v2 + carry
            carry = sum / 10

            currentNode.`val` = sum%10

            if (v1 != 0) left = left?.next
            if (v2 != 0) right = right?.next

            if (left != null || right != null || carry != 0) {
                var newNode = ListNode(0)
                currentNode.next = newNode
                currentNode = newNode
            }
        }

        return rootNode
    }
}
