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

//        var input = intArrayOf(1,2,3)
//        nextPermutation(input)
//        for (i in 0 until input.size) {
//            print("${input[i]} ")
//        }

//        var input = intArrayOf(4,5,6,7,0,1,2)
//        print(search(input, 3))

        var nums = intArrayOf(5,7,7,8,8,10)
//        var nums = intArrayOf(2,2)
//        var nums = intArrayOf(1,3)
//        var nums = intArrayOf(1,2,3)
        var result = searchRange(nums, 6)
        print("[${result[0]}, ${result[1]}]")
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

    fun search(nums: IntArray, target: Int): Int {
        var size = nums.size
        if (nums[0] <= target) {
            for (i in 0..size) {
                if (nums[i] == target) {
                    return i
                }
            }
        } else {
            for (i in size-1 downTo 0) {
                if (nums[i] == target) {
                    return i
                }
            }
        }

        return -1
    }


    fun searchRange(nums: IntArray, target: Int): IntArray {
        var size = nums.size
        if (size == 0) return intArrayOf(-1, -1)

//        var find = binarySearch(nums, target, 0, size/2, size - 1)
        var find = binarySearch(nums, target)
        if (find == -1) {
            return intArrayOf(-1, -1)
        } else {
            var result = IntArray(2)
            result[0] = find
            result[1] = find

            for(i in find -1 downTo 0) {
                if (nums[i] < target) {
                    break
                } else if (nums[i] == target) {
                    result[0] = i
                }
            }
            for (j in find+1 until size) {
                if (nums[j] > target) {
                    break
                } else if (nums[j] == target) {
                    result[1] = j
                }
            }
            return result
        }

    }

    private fun binarySearch(nums: IntArray, target: Int, left:Int, center:Int, right:Int):Int {
        if (center < 0 || center > nums.size - 1) return -1

        if (target == nums[center]) return center

        if (left >= right) return -1

        if (target > nums[center]) {
            return binarySearch(nums, target, center+1, (right + center) / 2, right)
        } else if (target < nums[center]) {
            return binarySearch(nums, target, left, center/2, center-1)
        } else {
            return center
        }
    }

    private fun binarySearch(nums: IntArray, target: Int):Int {
        var left = 0
        var right = nums.size - 1
        var center = (left+right)/2

        while (left <= right) {
            if (nums[center] > target) {
                right = center - 1
                center = (left+right)/2
            } else if (nums[center] < target){
                left = center + 1
                center = (left+right)/2
            } else {
                return center
            }
        }

        return -1
    }
}