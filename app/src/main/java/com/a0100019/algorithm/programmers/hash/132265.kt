package com.a0100019.algorithm.programmers.hash

class Solution132265 {

    fun solution(topping: IntArray): Int {
        var answer: Int = 0

        val leftMap = mutableMapOf<Int, Int>()
        val rightMap = mutableMapOf<Int, Int>()

        for(i in 0 until topping.size) {

            leftMap[topping[i]] = leftMap.getOrDefault(topping[i], 0) + 1

        }

        for(i in 0 until topping.size) {

            leftMap[topping[i]] = leftMap.getOrDefault(topping[i], 0) - 1
            rightMap[topping[i]] = rightMap.getOrDefault(topping[i], 0) + 1
            if(leftMap[topping[i]] == 0) leftMap.remove(topping[i])

            if(leftMap.size == rightMap.size) answer++

        }

        return answer
    }

}