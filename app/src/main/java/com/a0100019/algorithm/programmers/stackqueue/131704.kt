package com.a0100019.algorithm.programmers.stackqueue

class Solution131704 {

    fun solution(order: IntArray): Int {
        var answer: Int = 0

        val deque = ArrayDeque<Int>()

        var subBelt: Int = 0

        for(i in order) {

            while(subBelt < i) {
                subBelt++
                deque.add(subBelt)
            }

            if(deque.lastOrNull() == i) {
                answer++
                deque.removeLast()
            } else {
                return answer
            }


        }


        return answer
    }

}