package com.a0100019.algorithm.programmers.sorting

class SolutionSorting42746 {
    fun solution(numbers: IntArray): String {
        val sortedStrings = numbers.map { it.toString() }
            .sortedWith { a, b ->
                (b + a).compareTo(a + b)
            }
        //sortedWith나 Comparator는 반드시 Int를 반환하는 compareTo를 사용해야만 동작한다는 점을 꼭 기억하세요!
        //compareTo는 앞에꺼가 더 크면 1 같으면 0 작으면 -1
        //sortedWith는 양수면 뒤에꺼가 이김

        // 모든 숫자가 0인 경우 처리
        if (sortedStrings[0] == "0") return "0"

        return sortedStrings.joinToString("")
    }
}

fun main() {
    val sol = SolutionSorting42746()

    // 테스트 케이스
    println("결과 1: ${sol.solution(intArrayOf(6, 10, 2))}")
    // 예상: "6210"

    println("결과 2: ${sol.solution(intArrayOf(3, 30, 34, 5, 9))}")
    // 예상: "9534330"
}