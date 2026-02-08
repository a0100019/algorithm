package com.a0100019.algorithm.programmers.stackqueue

import java.util.ArrayDeque

//주식가격
class Solution42584 {
    fun solution(prices: IntArray): IntArray {
        val answer = IntArray(prices.size)
        val stack = ArrayDeque<Int>() // 관습적으로 스택이라 부릅니다

        for (i in prices.indices) {
            // 1. 스택이 비어있지 않고, 현재 가격이 스택 맨 위 가격보다 '작을' 때만 꺼냅니다.
            // stack.isNotEmpty() 체크가 필수입니다!
            while (stack.isNotEmpty() && prices[stack.last()] > prices[i]) {
                val lastIdx = stack.removeLast()
                answer[lastIdx] = i - lastIdx
            }
            // 2. 현재 인덱스는 '무조건' 넣습니다.
            // if-else로 나눌 필요 없이 밖으로 빼면 코드가 훨씬 깔끔해져요.
            stack.addLast(i)
        }

        // 3. 끝까지 살아남은 녀석들 처리 (작성하신 로직 완벽합니다!)
        while (stack.isNotEmpty()) {
            val index = stack.removeLast()
            answer[index] = prices.size - index - 1
        }

        return answer
    }
}

fun main() {
    val sol = Solution42584()

    // 테스트 케이스
    val prices = intArrayOf(1, 2, 3, 2, 3)
    println("결과: ${sol.solution(prices).contentToString()}")
    // 예상: [4, 3, 1, 1, 0]
}