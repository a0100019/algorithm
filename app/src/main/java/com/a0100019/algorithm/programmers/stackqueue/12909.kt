package com.a0100019.algorithm.programmers.stackqueue

import java.util.ArrayDeque

class Solution12909 {
    fun solution(s: String): Boolean {

        val queue = ArrayDeque<Char>()

        //s.split("")하면 앞뒤에 공백 하나 추가되며, 리스트 만드는데 메모리 소요, 직접 순회하도록 함
        for(i in s) {
            if(i == '(') {
                queue.addLast(i)
            } else {
                if(queue.isNotEmpty()) {
                    queue.removeLast()
                } else {
                    return false
                }
            }
        }

        return queue.isEmpty()

    }
}

fun main() {
    val sol = Solution12909()

    // 테스트 케이스
    val test1 = "()()"
    val test2 = "(())()"
    val test3 = ")()("
    val test4 = "(()("

    println("테스트 1 결과: ${sol.solution(test1)}") // 예상: true
    println("테스트 2 결과: ${sol.solution(test2)}") // 예상: true
    println("테스트 3 결과: ${sol.solution(test3)}") // 예상: false
    println("테스트 4 결과: ${sol.solution(test4)}") // 예상: false
}