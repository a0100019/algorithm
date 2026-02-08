package com.a0100019.algorithm.programmers.stackqueue

//같은 숫자는 싫어
class Solution12906 {
    fun solution(arr: IntArray): IntArray {
        val answer = mutableListOf<Int>()

        for(i in arr) {
            if(answer.isEmpty() || answer.last() != i ) {
                answer.add(i)
            }
        }

        return answer.toIntArray()
    }
}

fun main() {
    val sol = Solution12906()

    // 입출력 예시 데이터
    val test1 = intArrayOf(1, 1, 3, 3, 0, 1, 1)
    val test2 = intArrayOf(4, 4, 4, 3, 3)

    // 실행 및 결과 확인
    println("테스트 1 (예상 [1, 3, 0, 1]): ${sol.solution(test1).joinToString(", ")}")
    println("테스트 2 (예상 [4, 3]): ${sol.solution(test2).joinToString(", ")}")
}