package com.a0100019.algorithm.programmers.bruteforce

/**
 * 프로그래머스 - 모음 사전 (Level 2)
 * * [문제 요약]
 * 'A', 'E', 'I', 'O', 'U'만 사용하여 만든 5글자 이하의 단어 사전에서
 * 주어진 word가 몇 번째인지 구하기.
 * * [풀이 팁]
 * 1. 각 자릿수가 바뀔 때 건너뛰는 단어의 수(Weight)를 계산합니다.
 * 2. word를 한 글자씩 확인하며 (해당 알파벳 순서 * 가중치 + 1)을 더해줍니다.
 */
class Solution84512 {
    fun solution(word: String): Int {
        var answer = 0
        val vowels = "AEIOU" // indexOf를 쓰기 위해 String으로 선언하는 것이 편합니다.

        // 각 자리수(1, 2, 3, 4, 5번째)에서 알파벳 하나가 바뀔 때 건너뛰는 단어의 개수
        val weights = intArrayOf(781, 156, 31, 6, 1)

        // 1. word의 각 문자를 index와 함께 순회
        word.forEachIndexed { i, char ->
            // 2. 현재 문자가 vowels에서 몇 번째 인덱스인지 찾기 (A=0, E=1, I=2, O=3, U=4)
            val vowelIndex = vowels.indexOf(char)

            // 3. (vowelIndex * weights[i]) + 1 을 answer에 누적
            // 가중치를 곱해 앞선 알파벳들을 건너뛰고, +1을 통해 현재 글자 자체를 카운트합니다.
            answer += (vowelIndex * weights[i]) + 1
        }

        return answer
    }
}

/**
 * 로컬 테스트를 위한 메인 함수
 */
fun main() {
    val sol = Solution84512()

    println("Test 1 (AAAAE): ${sol.solution("AAAAE")} (Expected: 6)")
    println("Test 2 (AAAE): ${sol.solution("AAAE")} (Expected: 10)")
    println("Test 3 (I): ${sol.solution("I")} (Expected: 1563)")
    println("Test 4 (EIO): ${sol.solution("EIO")} (Expected: 1189)")
}