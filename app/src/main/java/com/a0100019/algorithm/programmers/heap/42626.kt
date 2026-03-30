package com.example.algorithm.programmers.heap

import java.util.*

class Solution42626 {
    fun solution(scoville: IntArray, K: Int): Int {
        var answer = 0

        // 1. 우선순위 큐(PriorityQueue) 생성 및 데이터 삽입
        // 기본적으로 낮은 숫자가 우선순위가 높습니다.
        val pq = PriorityQueue<Int>()

        // TODO: scoville 배열의 모든 원소를 pq에 추가하세요.
        for(i in scoville) {
            pq.add(i)
        }

        // 2. 반복 탐색 시작
        // 조건: pq의 가장 작은 값이 K보다 작고, pq의 크기가 2 이상일 때
        while (pq.peek() < K && pq.size >= 2) {
            // TODO: 가장 작은 것과 두 번째로 작은 것을 꺼내서 섞으세요.
             val first = pq.poll()
             val second = pq.poll()

            // TODO: 섞은 결과를 다시 큐에 넣고 answer를 증가시키세요.
            val sum = first + second*2
            pq.add(sum)
            answer++

        }

        // 3. 최종 결과 확인
        // TODO: 루프가 끝난 후, 가장 작은 값이 K 이상인지 확인하세요.
        // 만약 끝까지 K를 넘지 못했다면 -1을 반환해야 합니다.

        return if (pq.peek() >= K) answer else -1
    }
}

/**
 * 로컬 실행 확인용 메인 함수
 */
fun main() {
    val sol = Solution42626()

    val scoville = intArrayOf(1, 2, 3, 9, 10, 12)
    val k = 7

    println("결과: ${sol.solution(scoville, k)} (정답: 2)")
}