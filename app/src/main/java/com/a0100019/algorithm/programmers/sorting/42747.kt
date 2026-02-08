package com.a0100019.algorithm.programmers.sorting

class SolutionSorting42747 {
    fun solution(citations: IntArray): Int {
        var answer = 0

        val sorted = citations.sorted()

        if(citations.toSet() == setOf(0)) return 0

        for(i in citations.size downTo 0) {
            if(sorted[citations.size - i] >= i) return i
        }

        return 0
    }
}

fun main() {
    val sol = SolutionSorting42747()

    // 테스트 케이스들
    println("결과 1: ${sol.solution(intArrayOf(3, 0, 6, 1, 5))}")
    // 예상: 3 (기본 예제)

    println("결과 2: ${sol.solution(intArrayOf(10, 8, 5, 4, 3))}")
    // 예상: 4 (4회 이상 인용된 논문이 4편 이상)

    println("결과 3: ${sol.solution(intArrayOf(25, 8, 5, 3, 3))}")
    // 예상: 3 (3회 이상 인용된 논문이 3편 이상)

    println("결과 4: ${sol.solution(intArrayOf(9, 7, 6, 2, 1))}")
    // 예상: 3

    println("결과 5: ${sol.solution(intArrayOf(0, 0, 0))}")
    // 예상: 0

    println("결과 6: ${sol.solution(intArrayOf(10, 10, 10))}")
    // 예상: 3
}