package com.a0100019.algorithm.programmers.bruteforce

import java.util.*

class Solution42839 {
    fun solution(numbers: String): Int {
        val numberSet = mutableSetOf<Int>()

        // 1. 모든 숫자 조합 만들기 (재귀 함수 호출)
        recursive("", numbers, numberSet)

        // 2. 소수 개수 세기
        var count = 0
        for (num in numberSet) {
            if (isPrime(num)) count++
        }

        return count
    }

    /**
     * 모든 숫자 조합을 만드는 재귀 함수
     * @param comb: 현재까지 조합된 문자열
     * @param others: 아직 사용하지 않은 남은 숫자 조각들
     * @param set: 중복 제거를 위해 숫자를 담을 집합
     */
    private fun recursive(comb: String, others: String, set: MutableSet<Int>) {
        // 현재까지 만든 조합이 비어있지 않다면 숫자로 변환해 Set에 추가
        if (comb.isNotEmpty()) {
            set.add(comb.toInt())
        }

        // 남은 숫자 조각들 중에서 하나를 선택해 다음 조합을 만듦
        for (i in others.indices) {
            recursive(
                comb + others[i],
                others.substring(0, i) + others.substring(i + 1),
                set
            )
        }
    }

    /**
     * 소수 판별 함수
     */
    private fun isPrime(n: Int): Boolean {
        // 0과 1은 소수가 아님
        if (n < 2) return false

        // 2부터 n의 제곱근까지 나누어 떨어지는지 확인
        val limit = Math.sqrt(n.toDouble()).toInt()
        for (i in 2..limit) {
            if (n % i == 0) return false
        }
        return true
    }
}

    fun main() {
        val sol = Solution42839()

        // 입출력 예 테스트
        println("Test 1 (\"17\"): ${sol.solution("17")} (정답: 3)")
        println("Test 2 (\"011\"): ${sol.solution("011")} (정답: 2)")
    }