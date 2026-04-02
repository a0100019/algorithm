package com.a0100019.algorithm.programmers.normal

class Solution64065 {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()

        var list = s.drop(2).dropLast(2).split("},{").sortedBy{it.length}
        for(i in list) {
            val iList = i.split(",").forEach {
                if(it.toInt() !in answer) {
                    answer += it.toInt()
                }
            }
        }

        return answer
    }
}

fun main() {
    val sol = Solution64065()
    println(sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}").toList())
}