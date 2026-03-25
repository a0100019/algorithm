package com.a0100019.algorithm.programmers.bruteforce

//모의고사
class Solution42840 {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()

        // TODO: 로직 구현
        val human1 = intArrayOf(1,2,3,4,5)
        val human2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val human3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val answerArray = IntArray(3)

        for(i in answers.indices) {
            if(answers[i] == human1[i%5]) answerArray[0]++
            if(answers[i] == human2[i%8]) answerArray[1]++
            if(answers[i] == human3[i%10]) answerArray[2]++
        }

        return answerArray.indices.filter { answerArray[it] == answerArray.max() }.map { it+1 }.toIntArray()
    }
}

fun main() {
    val sol = Solution42840()

    // 입출력 예 #1
    val answers1 = intArrayOf(1, 2, 3, 4, 5)
    val result1 = sol.solution(answers1)
    println("Test 1: ${result1.contentToString()} (Expected: [1])")

    // 입출력 예 #2
    val answers2 = intArrayOf(1, 3, 2, 4, 2)
    val result2 = sol.solution(answers2)
    println("Test 2: ${result2.contentToString()} (Expected: [1, 2, 3])")
}