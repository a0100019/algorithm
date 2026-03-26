package com.a0100019.algorithm.programmers.bruteforce

import kotlin.math.abs

class Solution86971 {
    // 전력망 정보를 담을 인접 리스트
    private lateinit var adj: Array<MutableList<Int>>

    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer = n // 최대 차이는 n을 넘지 않음

        // 1. 인접 리스트 초기화 (1번부터 n번까지 사용)
        adj = Array(n + 1) { mutableListOf<Int>() }
        for (wire in wires) {
            adj[wire[0]].add(wire[1])
            adj[wire[1]].add(wire[0])
        }

        // 2. 모든 전선을 하나씩 끊어보기
        for (wire in wires) {
            val v1 = wire[0]
            val v2 = wire[1]

            // v1과 v2 사이의 연결을 끊었다고 가정하고 탐색
            // 힌트: 탐색 함수(bfs 또는 dfs)를 호출할 때
            // 현재 끊은 전선(v1, v2)은 통과하지 않도록 조건을 거세요.

            val count = bfs(v1, v2, n) // v1에서 시작해서 v2를 거치지 않고 갈 수 있는 노드 수

            val diff = abs(count - (n - count))
            answer = minOf(answer, diff)
        }

        return answer
    }

    private fun bfs(start: Int, blocked: Int, n: Int): Int {
        var count = 0
        val visited = BooleanArray(n + 1)
        val queue = mutableListOf<Int>()

        // TODO: 일반적인 탐색 로직을 작성하세요.
        // 다만, 다음에 이동할 노드가 'blocked'라면 이동하지 않아야 합니다.

        return count
    }
}

// 안드로이드 스튜디오에서 실행 확인을 위한 메인 함수
fun main() {
    val s = Solution86971()

    // 예제 1 테스트
    val n1 = 9
    val wires1 = arrayOf(
        intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 4),
        intArrayOf(4, 5), intArrayOf(4, 6), intArrayOf(4, 7),
        intArrayOf(7, 8), intArrayOf(7, 9)
    )
    println("Test 1: ${s.solution(n1, wires1)}") // 예상 결과: 3
}