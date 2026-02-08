package com.a0100019.algorithm.programmers.stackqueue

import java.util.ArrayDeque

class Solution42586 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {

        // 여기에 로직을 작성하세요.
        // ArrayDeque<Int>() 등을 활용해볼 수 있습니다.
        val queue = ArrayDeque<Int>()
        for(i in progresses.indices) {
            queue.addLast((100 - progresses[i] + speeds[i] - 1) / speeds[i])
        }

        val answer = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val now = queue.removeFirst() // 기준이 되는 작업 꺼내기
            var count = 1 // 이번 배포에 포함될 기능 개수

            // 다음 작업들이 'now'보다 빨리 끝난다면 함께 배포
            while (queue.isNotEmpty() && queue.first <= now) {
                queue.removeFirst()
                count++
            }

            // 한 그룹(배포 단위)이 결정되면 여기서 answer에 추가
            answer.add(count)
        }

        return answer.toIntArray()
    }
}

fun main() {
    val sol = Solution42586()

    // 테스트 케이스 1
    val progresses1 = intArrayOf(93, 30, 55)
    val speeds1 = intArrayOf(1, 30, 5)
    println("테스트 1 결과: ${sol.solution(progresses1, speeds1).contentToString()}")
    // 예상 출력: [2, 1]

    // 테스트 케이스 2
    val progresses2 = intArrayOf(95, 90, 99, 99, 80, 99)
    val speeds2 = intArrayOf(1, 1, 1, 1, 1, 1)
    println("테스트 2 결과: ${sol.solution(progresses2, speeds2).contentToString()}")
    // 예상 출력: [1, 3, 2]
}