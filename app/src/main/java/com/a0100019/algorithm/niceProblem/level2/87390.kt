package com.a0100019.algorithm.niceProblem.level2

class Solution87390 {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        // 1. 결과 배열의 크기 계산 (right - left + 1)
        val size = (right - left + 1).toInt()
        val answer = IntArray(size)

        // 2. left부터 right까지 반복하며 값 계산
        for (i in 0 until size) {
            // 현재의 1차원 인덱스 위치
            val currentIndex = left + i

            // TODO: currentIndex를 이용해 row와 col을 구하세요.
             val row = currentIndex / n
             val col = currentIndex % n

            // TODO: max(row, col) + 1 공식을 적용해 answer[i]에 넣으세요.
            // 참고: max 연산 시 Long 타입을 고려하여 계산 후 Int로 변환하세요.
            answer[i] = (maxOf(row,  col) + 1).toInt()
        }

        return answer
    }
}

/**
 * 로컬 테스트용 메인 함수
 */
fun main() {
    val sol = Solution87390()

    // 예제 1: n=3, left=2, right=5
    // 결과: [3, 2, 2, 3]
    println("결과 1: ${sol.solution(3, 2, 5).contentToString()}")

    // 예제 2: n=4, left=7, right=14
    // 결과: [4, 3, 3, 3, 4, 4, 4, 4]
    println("결과 2: ${sol.solution(4, 7, 14).contentToString()}")
}