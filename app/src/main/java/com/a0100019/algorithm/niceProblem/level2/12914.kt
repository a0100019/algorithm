package com.a0100019.algorithm.niceProblem.level2

class Solution12914 {

    fun solution(arr: IntArray): Int {
        var answer = arr[0]

        for(i in 1 until arr.size) {
            answer = getLCM(answer, arr[i])
        }

        return answer
    }

    //최소공배수 최대공략수 유클리드 호제법
    private fun getGCD(x: Int, y: Int): Int {
        var a = x
        var b = y
        while(b != 0) {
            val temp = a % b
            a = b
            b = temp
        }

        return a
    }

    private fun getLCM(x: Int, y: Int): Int {
        return (x * y)/getGCD(x, y)
    }


}

fun main() {
    val sol = Solution12914()
    println(sol.solution(intArrayOf(2, 6, 8, 14)))
}