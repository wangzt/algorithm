package com.tomsky.leetcode

class DupArray {
    fun test() {
//        val input = intArrayOf(1, 1, 2)
//        val size = removeDuplicates(input)
//        println("size:$size")
//        for (i in 0 until size) {
//            print("${input[i]} ")
//        }

//        val input = intArrayOf(0,1,2,2,3,0,4,2)
//        val data = 2
//        val size = removeDupElement(input, data)
//        println("size:$size")
//        for (i in 0 until size) {
//            print("${input[i]} ")
//        }

        var input = intArrayOf(1,2,3)
        nextPermutation(input)
        for (i in 0 until input.size) {
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

    fun nextPermutation(nums: IntArray): Unit {
        var localMin = -1
        for (i in nums.size-1 downTo 1 ) {
            if (nums[i] > nums[i-1]) {
                localMin = i - 1
                break
            }
        }

        if (localMin == -1) {
            swapSort(nums, 0, nums.size)
            return
        }

        var nextHNumber = -1
        var nextHIndex = -1
        for (j in localMin+1 until nums.size) {
            if (nums[j] > nums[localMin]) {
                nextHNumber = nums[j]
                nextHIndex = j
            } else {
                break
            }
        }
        nums[nextHIndex] = nums[localMin]
        nums[localMin] = nextHNumber
        swapSort(nums, localMin+1, nums.size)
    }

    private fun swapSort(nums: IntArray, lo:Int, hi:Int) {
        var i = lo
        var j = hi - 1
        while (i<j) {
            var t = nums[j]
            nums[j] = nums[i]
            nums[i] = t
            i++
            j--
        }
    }
}