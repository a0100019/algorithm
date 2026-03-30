package com.a0100019.algorithm.programmers.bruteforce

import java.util.*

class Solution1844 {
    fun solution(maps: Array<IntArray>): Int {
        val n = maps.size
        val m = maps[0].size

        // 1. 방향 설정 (상, 하, 좌, 우 이동을 위한 dx, dy 배열)
        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)

        // 2. 방문 여부를 체크할 배열 (n x m 크기)
        val visited = Array(n) { BooleanArray(m) }

        // 3. BFS를 위한 큐 생성 (x좌표, y좌표, 이동거리 를 담을 데이터 구조)
        // 예: Queue<Triple<Int, Int, Int>> 또는 별도의 데이터 클래스 활용
        val queue: Queue<Node> = LinkedList()

        // 4. 시작점 (0, 0)을 큐에 삽입하고 방문 처리 (시작 칸수 1 포함)
        queue.add(Node(0, 0, 1))
        visited[0][0] = true

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            // 5. 종료 조건: 현재 좌표가 상대 팀 진영(n-1, m-1)인가?
            if (current.x == n - 1 && current.y == m - 1) {
                // TODO: 현재까지의 이동 거리(dist)를 반환하세요.
                return current.dist
            }

            // 6. 4방향 탐색
            for (i in 0 until 4) {
                val nx = current.x + dx[i]
                val ny = current.y + dy[i]

                // TODO: 아래 조건들을 만족하는지 체크하세요.
                // - nx, ny가 맵의 범위를 벗어나지 않았는가?
                // - maps[nx][ny]가 벽(0)이 아닌 길(1)인가?
                // - visited[nx][ny]가 false(미방문)인가?

                if (
                    nx in 0..<n &&
                    ny in 0..<m &&
                    maps[nx][ny] == 1 && !visited[nx][ny]
                ) {
                    // TODO: 방문 표시를 하고 큐에 새 좌표와 늘어난 거리값을 넣으세요.
                    visited[nx][ny] = true
                    queue.add(Node(nx, ny, current.dist+1))
                }
            }
        }

        // 7. 목적지에 도달할 수 없는 경우
        return -1
    }

    // 좌표와 거리를 담을 데이터 클래스
    data class Node(val x: Int, val y: Int, val dist: Int)
}

/**
 * 로컬 테스트를 위한 메인 함수
 */
fun main() {
    val sol = Solution1844()

    // 테스트 케이스 1
    val maps1 = arrayOf(
        intArrayOf(1, 0, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1),
        intArrayOf(1, 0, 1, 1, 1),
        intArrayOf(1, 1, 1, 0, 1),
        intArrayOf(0, 0, 0, 0, 1)
    )
    println("결과 1: ${sol.solution(maps1)} (정답: 11)")

    // 테스트 케이스 2
    val maps2 = arrayOf(
        intArrayOf(1, 0, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1),
        intArrayOf(1, 0, 1, 1, 1),
        intArrayOf(1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 1)
    )
    println("결과 2: ${sol.solution(maps2)} (정답: -1)")
}