package com.a0100019.algorithm.programmers.dp

class Solution12945 {
    fun solution(n: Int): Int {

        val fibo = IntArray(n+1)

        fibo[0] = 0
        fibo[1] = 1

        for(i in 2..n) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567
        }

        return fibo[n]
    }
}

fun main() {
    val sol = Solution12945()

    // 테스트 케이스 확인
    println("n=3 결과: ${sol.solution(3)} (기대값: 2)")
    println("n=5 결과: ${sol.solution(5)} (기대값: 5)")
}