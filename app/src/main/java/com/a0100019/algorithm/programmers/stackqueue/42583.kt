package com.a0100019.algorithm.programmers.stackqueue

import java.util.ArrayDeque

//다리를 지나는 트럭
class Solution42583 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        // 로직을 작성하세요.
        val queue = ArrayDeque<Int>()
        var truckCount = 0
        var currentWeight = 0

        repeat(bridge_length) {queue.add(0)}

        while(truckCount<truck_weights.size) {
            val removeTruck = queue.removeFirst()
            currentWeight -= removeTruck

            if(currentWeight + truck_weights[truckCount] <= weight) {
                queue.addLast(truck_weights[truckCount])
                currentWeight += truck_weights[truckCount]
                truckCount++
            } else {
                queue.addLast(0)
            }

            answer++

        }

        answer += bridge_length

        return answer
    }
}

fun main() {
    val sol = Solution42583()

    // 테스트 케이스 1
    println("테스트 1 결과: ${sol.solution(2, 10, intArrayOf(7, 4, 5, 6))}")
    // 예상: 8

    // 테스트 케이스 2
    println("테스트 2 결과: ${sol.solution(100, 100, intArrayOf(10))}")
    // 예상: 101

    // 테스트 케이스 3
    println("테스트 3 결과: ${sol.solution(100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10))}")
    // 예상: 110
}