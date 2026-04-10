package com.a0100019.algorithm.niceProblem.level2

import kotlin.math.sqrt

class Solution42839 {
    // 모든 조합된 숫자를 담을 Set (중복 제거용)
    val numberSet = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        // 1. 모든 숫자 조합 생성 (재귀 함수 호출)
        permutation("", numbers)

        // 2. 생성된 숫자 중 소수의 개수 카운트
        return numberSet.count { isPrime(it) }
    }

    // 순열을 만드는 재귀 함수
    private fun permutation(prefix: String, str: String) {
        if (prefix.isNotEmpty()) {
            numberSet.add(prefix.toInt())
        }

        for (i in str.indices) { // 1. 내가 가진 종이 조각(str)을 하나씩 다 살펴본다.

            // 2. 현재 내 손에 쥐고 있는 조합(prefix)에 지금 선택한 글자(str[i])를 붙인다.
            val nextPrefix = prefix + str[i]

            // 3. 방금 내가 써버린 글자(i번째)만 쏙 빼고 나머지 글자들을 모은다.
            val remainingStr = str.substring(0, i) + str.substring(i + 1)

            // 4. 새로운 조합과 남은 글자들을 가지고 다시 처음부터 작업을 반복한다(재귀).
            permutation(nextPrefix, remainingStr)
        }
    }

    // 소수 판별 함수
    private fun isPrime(num: Int): Boolean {
        if (num < 2) return false

        // 2부터 숫자의 제곱근까지만 확인하면 효율적임
        val limit = sqrt(num.toDouble()).toInt()
        for (i in 2..limit) {
            if (num % i == 0) return false
        }
        return true
    }
}