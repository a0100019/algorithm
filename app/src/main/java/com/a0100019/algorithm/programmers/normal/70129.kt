package com.a0100019.algorithm.programmers.normal

class Solution70129 {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()

        var count = 0
        var numberString = s
        var removeZeroCount = 0

        while(numberString != "1") {
            // 0 제거, 제로 카운트 추가
            val oneCount = numberString.count { it == '1' }
            val zeroCount = numberString.length - oneCount
            removeZeroCount += zeroCount

            numberString = oneCount.toString(2)

            // 카운트 추가
            count++
        }

        return intArrayOf(count, removeZeroCount)
    }
}