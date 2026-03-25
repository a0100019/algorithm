package com.a0100019.algorithm.programmers.bruteforce

class Solution86491 {
    fun solution(sizes: Array<IntArray>): Int {
        var maxWidth = 0
        var maxHeight = 0

        for ((w, h) in sizes) {
            // 명함을 돌려서(w, h 중 큰 값/작은 값 추출) 최댓값 갱신
            maxWidth = maxOf(maxWidth, maxOf(w, h))
            maxHeight = maxOf(maxHeight, minOf(w, h))
        }

        return maxWidth * maxHeight
    }
}

fun main() {
    val sol = Solution86491()

    // 입출력 예시 1
    val sizes1 = arrayOf(
        intArrayOf(60, 50),
        intArrayOf(30, 70),
        intArrayOf(60, 30),
        intArrayOf(80, 40)
    )
    println("예제 1 결과: ${sol.solution(sizes1)} (정답: 4000)")

    // 입출력 예시 2
    val sizes2 = arrayOf(
        intArrayOf(10, 7),
        intArrayOf(12, 3),
        intArrayOf(8, 15),
        intArrayOf(14, 7),
        intArrayOf(5, 15)
    )
    println("예제 2 결과: ${sol.solution(sizes2)} (정답: 120)")

    // 입출력 예시 3
    val sizes3 = arrayOf(
        intArrayOf(14, 4),
        intArrayOf(19, 6),
        intArrayOf(6, 16),
        intArrayOf(18, 7),
        intArrayOf(7, 11)
    )
    println("예제 3 결과: ${sol.solution(sizes3)} (정답: 133)")
}