package com.tomsky.linkedlist

class LinkedList<T> {
    // 头结点
    var head: Node<T>? = null
    
    // 取决于head是否为空
    var isEmpty: Boolean = (head == null)

    // 获取first
    fun first(): Node<T>? = head

    // 获取last节点，需要一直next才能到达last节点
    fun last(): Node<T>? {
        var node = head
        if (node != null) {
            while (node?.next != null) {
                node = node.next
            }
            return node
        } else {
            return null
        }
    }

    fun count(): Int {
        var node = head
        if (node != null) {
            var count = 1
            while(node?.next != null) {
                node = node.next
                count++
            }
            return count
        } else {
            return 0
        }
    }

    fun append(value: T) {
        var newNode = Node(value)
        var lastNode = this.last()
        if (lastNode != null) {
            newNode.previous = lastNode
            lastNode.next = newNode
        } else {
            head = newNode
        }
    }

    fun remove(node: Node<T>) : T {
        val prev = node.previous
        val next = node.next
        if (prev != null) {
            prev.next = next
        } else {
            head = next
        }

        next?.previous = prev

        node.previous = null
        node.next = null
        
        return node.value
    }
}

class Node<T>(value: T) {
    var value: T = value
    var next: Node<T>? = null
    var previous: Node<T>? = null
}