package com.a0100019.algorithm.programmers.stackqueue

class Solution154538 {

    fun solution(x: Int, y: Int, n: Int): Int {
        if (x==y) return 0

        var answer: Int = 0

        val deque = ArrayDeque<Pair<Int, Int>>()
        deque.add(Pair(x, 0))

        val visited = BooleanArray(y+1)
        visited[x] = true

        while(deque.isNotEmpty()) {
            val firstDeque = deque.removeFirst()

            val list = intArrayOf(firstDeque.first + n, firstDeque.first*2, firstDeque.first*3)

            for( i in list) {

                if(i == y) return firstDeque.second+1

                if(i < y && !visited[i]) {
                    visited[i] = true
                    deque.add(Pair(i, firstDeque.second+1))
                }

            }
        }

        return -1
    }

}