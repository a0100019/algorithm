package com.a0100019.algorithm.programmers.hash

class Solution42578 {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1 // 곱셈을 해야 하므로 1로 시작합니다.

        val map = mutableMapOf<String, Int>()
        for(i in clothes) {
            map[i[1]] = map.getOrDefault(i[1], 0) + 1
        }

        map.forEach { answer *= (it.value + 1) }

        return answer -1

//        return clothes.groupBy { it[1] } // 종류별로 그룹화
//            .values
//            .fold(1) { acc, list -> acc * (list.size + 1) } - 1
    }
}

fun main() {
    val sol = Solution42578()

    // 입출력 예시 데이터 (2차원 배열)
    val test1 = arrayOf(
        arrayOf("yellow_hat", "headgear"),
        arrayOf("blue_sunglasses", "eyewear"),
        arrayOf("green_turban", "headgear")
    )
    val test2 = arrayOf(
        arrayOf("crow_mask", "face"),
        arrayOf("blue_sunglasses", "face"),
        arrayOf("smoky_makeup", "face")
    )

    // 실행 및 결과 확인
    println("테스트 1 (예상 5): ${sol.solution(test1)}")
    println("테스트 2 (예상 3): ${sol.solution(test2)}")
}