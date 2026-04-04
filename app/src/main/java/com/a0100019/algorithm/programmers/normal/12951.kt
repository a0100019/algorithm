package com.a0100019.algorithm.programmers.normal

class Solution12951 {
    fun solution(s: String): String {
        var answer = ""

        return s.split(" ").joinToString(" ") {
            it.mapIndexed { index, c ->
                if (index == 0) {
                    c.uppercase()
                } else {
                    c.lowercase()
                }
            }.joinToString("")
        }
    }
}

fun main() {
    val sol = Solution12951()

    println(sol.solution("3people unFollowed me"))

}

