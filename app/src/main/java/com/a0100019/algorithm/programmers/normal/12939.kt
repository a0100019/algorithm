package com.a0100019.algorithm.programmers.normal

import kotlin.math.min

class Solution12939 {
    fun solution(s: String): String {
        var answer = ""
        return s.split(" ").minOfOrNull { it.toInt() }.toString() + " " + s.split(" ").maxOfOrNull { it.toInt() }.toString()
    }
}

fun main() {
    val sol = Solution12939()

    println(sol.solution("1 2 3 4"))
}