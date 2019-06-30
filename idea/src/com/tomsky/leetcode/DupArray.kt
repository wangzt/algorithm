package com.tomsky.leetcode

class DupArray {
    fun test() {
//        val input = intArrayOf(1, 1, 2)
//        val size = removeDuplicates(input)
//        println("size:$size")
//        for (i in 0 until size) {
//            print("${input[i]} ")
//        }

        val input = intArrayOf(0,1,2,2,3,0,4,2)
        val data = 2

        val size = removeDupElement(input, data)
        println("size:$size")
        for (i in 0 until size) {
            print("${input[i]} ")
        }
    }

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size == 1) return 1
        if (nums.isEmpty()) return 0

        var result = 1

        for (i in 1 until nums.size) {
            if (nums[result-1] != nums[i]) {
                nums[result] = nums[i]
                result++
            }
        }


        return result
    }

    fun removeDupElement(nums: IntArray, data:Int):Int {

        var result = 0
        for (i in 0 until nums.size) {
            if (nums[i] != data) {
                if (i > result) {
                    nums[result] = nums[i]
                }
                result++
            }
        }
        return result
    }
}