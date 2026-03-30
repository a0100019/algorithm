package com.a0100019.algorithm.programmers.stack

class Solution12973 {
    fun solution(s: String): Int {

        // 1. 스택 자료구조 준비 (Character 타입을 담는 Stack)
        val deque = ArrayDeque<Char>()

        for(char in s) {
            if(deque.isNotEmpty()) {
                val lastChar = deque.lastOrNull()
                if(lastChar == char) {
                    deque.removeLast()
                } else {
                    deque.addLast(char)
                }
            } else {
                deque.addLast(char)
            }

        }

        return if(deque.isEmpty()) 1 else 0
    }
}

/**
 * 로컬 실행 확인용 메인 함수
 */
fun main() {
    val sol = Solution12973()

    println("결과 1: ${sol.solution("baabaa")} (정답: 1)")
    println("결과 2: ${sol.solution("cdcd")} (정답: 0)")
}