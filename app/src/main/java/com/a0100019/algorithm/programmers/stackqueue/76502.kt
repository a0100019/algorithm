package com.a0100019.algorithm.programmers.stackqueue

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0

        val dq = ArrayDeque<Char>()

        for(i in s) {
            dq.add(i)
        }

        repeat(dq.size) {
            val resertDq = ArrayDeque<Char>()

            repeat(dq.size) {
                val first = dq.removeFirst()

                if(resertDq.isEmpty()) {
                    resertDq.add(first)
                } else {
                    if(first in listOf('[', '(', '{')) {
                        resertDq.add(first)
                    } else if(first == ']') {
                        if(resertDq.last() == '[') {
                            resertDq.removeLast()
                        }
                    } else if(first == '}') {
                        if(resertDq.last() == '{') {
                            resertDq.removeLast()
                        }
                    } else if(first == ')') {
                        if(resertDq.last() == '(') {
                            resertDq.removeLast()
                        }
                    }

                }

                dq.add(first)

            }

            if(resertDq.isEmpty()) answer++

            val first = dq.removeFirst()
            dq.add(first)

        }

        return answer
    }
}