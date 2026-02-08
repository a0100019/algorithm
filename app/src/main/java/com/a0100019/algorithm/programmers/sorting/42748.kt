package com.a0100019.algorithm.programmers.sorting

class SolutionSorting42748 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = IntArray(commands.size)

        // 여기에 로직을 작성하세요.
        for(i in commands.indices) {
            val command = commands[i]
            answer[i] = array.sliceArray(command[0]-1..command[1]-1).sorted().get(command[2]-1)
        }

        return answer
    }
}

fun main() {
    val sol = SolutionSorting42748()

    // 테스트 케이스
    val array = intArrayOf(1, 5, 2, 6, 3, 7, 4)
    val commands = arrayOf(
        intArrayOf(2, 5, 3),
        intArrayOf(4, 4, 1),
        intArrayOf(1, 7, 3)
    )

    val result = sol.solution(array, commands)
    println("결과: ${result.contentToString()}")
    // 예상: [5, 6, 3]
}