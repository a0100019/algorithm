package com.a0100019.algorithm.programmers.set

class Solution131701 {
    fun solution(elements: IntArray): Int {
        var answer: Int = 0

        val doubleElements = elements + elements

        val set = mutableSetOf<Int>()

        for(i in elements.indices) {
            var sum = 0
            for(j in 0..i) {
                sum += elements[j]
            }

            set.add(sum)

            repeat(elements.size-1) {
                sum -= doubleElements[it]
                sum += doubleElements[it+i+1]
                set.add(sum)
            }


        }


        return set.size
    }
}

fun main() {
    val sol = Solution131701()
    println(sol.solution(intArrayOf(7,9,1,1,4)))
}