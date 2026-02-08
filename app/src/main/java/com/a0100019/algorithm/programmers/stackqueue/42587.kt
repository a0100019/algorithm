package com.a0100019.algorithm.programmers.stackqueue

import java.util.ArrayDeque

class Solution42587 {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        // 1. 프로세스의 원래 위치(index)와 우선순위를 함께 관리할 수 있는 구조를 고민해보세요.
        // 2. ArrayDeque를 활용해 프로세스를 관리하세요.
        // 3. 문제의 규칙(1~3번)에 따라 반복문을 구성해보세요.

        val queue = ArrayDeque<Pair<Int, Int>>()
        for(i in priorities.indices) {
            queue.addLast(Pair(i, priorities[i]))
        }

        while(true) {
            val value = queue.removeFirst()
            //if(queue.any { it.second > value.second })
            if(queue.isNotEmpty() && value.second < queue.maxOf{it.second}) {
                queue.addLast(value)
            } else {
                answer++
                if(value.first == location) break
            }
        }


        return answer
    }
}

fun main() {
    val sol = Solution42587()

    // 테스트 케이스 1
    val priorities1 = intArrayOf(2, 1, 3, 2)
    val location1 = 2
    println("테스트 1 결과: ${sol.solution(priorities1, location1)}") // 예상: 1

    // 테스트 케이스 2
    val priorities2 = intArrayOf(1, 1, 9, 1, 1, 1)
    val location2 = 0
    println("테스트 2 결과: ${sol.solution(priorities2, location2)}") // 예상: 5
}