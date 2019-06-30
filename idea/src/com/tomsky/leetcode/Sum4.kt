package com.tomsky.leetcode



class Sum4 {

    fun test() {
        var nums = intArrayOf(1,1,1,2,2,2,3,3,3,4,4,4,5,6,7,8)
        var time = System.currentTimeMillis()
        var res = fourSum(nums, 15)
        println("cost time:${System.currentTimeMillis() - time}")

        res.forEach {
            println("result:${it[0]}, ${it[1]}, ${it[2]}, ${it[3]}")
        }
    }

    fun fourSum(nums: IntArray, target:Int):List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()


        for (i in 0..nums.size-4) {
            if (i - 1 >= 0 && nums[i] == nums[i-1]) continue

            for (j in i+1..nums.size-3) {
                if (j -1 > i && nums[j] == nums[j-1]) continue
                var left  = j + 1
                var right = nums.size - 1
                while (left < right) {
                    if (nums[left] + nums[right] == target - nums[i] - nums[j]) {
                        res.add(listOf(nums[i], nums[j], nums[left++], nums[right--]))
                        while (left < nums.size && nums[left]==nums[left-1]) left++
                        while (right > j && nums[right]== nums[right+1]) right--
                    } else if (nums[left] + nums[right] < target - nums[i] -nums[j]) {
                        left++
                    } else {
                        right--
                    }
                }
            }
        }

        return res
    }

}