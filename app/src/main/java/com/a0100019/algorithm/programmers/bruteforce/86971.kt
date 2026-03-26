package com.a0100019.algorithm.programmers.bruteforce

import kotlin.math.*


class Solution86971 {
    private lateinit var adj: Array<MutableList<Int>>

    fun solution(n: Int, wires: Array<IntArray>): Int {
        var min = n
        adj = Array(n+1){ mutableListOf<Int>()}

        for(wire in wires) {
            adj[wire[0]].add(wire[1])
            adj[wire[1]].add(wire[0])
        }

        for(wire in wires) {
            val start = wire[0]
            val blocked = wire[1]

            val count = bfs(start, blocked, n)

            min = minOf(min, abs(count-(n-count)))
        }

        return min
    }


    private fun bfs(start: Int, blocked: Int, n: Int): Int {
        var count = 0
        val visited = BooleanArray(n+1)

        val queue = mutableListOf<Int>()

        queue.add(start)
        visited[start] = true
        count++

        while(queue.isNotEmpty()) {
            val current = queue.removeAt(0)

            for(i in adj[current]) {
                if(i != blocked && !visited[i]) {
                    queue.add(i)
                    visited[i] = true
                    count++
                }
            }

        }

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