package com.a0100019.algorithm.programmers.hash

class Solution131127 {

    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {

        var answer: Int = 0

        val discountMap = mutableMapOf<String, Int>()
        val wantMap = mutableMapOf<String, Int>()
        for(i in want.indices) {
            wantMap[want[i]] = number[i]
        }

        repeat(10) {
            discountMap[discount[it]] = discountMap.getOrDefault(discount[it], 0) + 1
        }

        for(i in 0 .. discount.size-10) {
            var check = true
            for(j in want) {
                if(wantMap[j]!! > discountMap.getOrDefault(j, 0)) check = false
            }

            if(check) answer++

            if(i == discount.size-10) continue

            discountMap[discount[i]] = discountMap.getOrDefault(discount[i], 0) - 1
            discountMap[discount[i+10]] = discountMap.getOrDefault(discount[i+10], 0) + 1

        }

        return answer
    }

}
