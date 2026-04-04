package com.a0100019.algorithm.programmers.greedy

class Solution138476 {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var result = 0
        val map = mutableMapOf<Int, Int>()
        for(i in tangerine) {
            map[i] = map.getOrDefault(i, 0) + 1
        }

        val countMap = map.map { it.value }.sortedDescending()
        countMap.forEach {
            if(answer >= k) return result
            answer += it
            result++
        }

        return result
    }
}

fun main() {
    val sol = Solution138476()

    println(sol.solution(6,	intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
}