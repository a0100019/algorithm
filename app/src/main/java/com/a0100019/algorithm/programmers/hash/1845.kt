package com.a0100019.algorithm.programmers.hash

//폰켓몬

class Solution1845 {
    fun solution(nums: IntArray): Int {
        var answer = 0

        // 여기에 로직을 작성해보세요!
        val map = mutableMapOf<Int, Int>()
        for(i in nums) {
            map[i] = map.getOrDefault(i, 0) + 1
        }
        val num2 = nums.count()/2

        //toSet()하면 중복 제거됨
        return minOf(num2, nums.toSet().size)
    }
}

fun main() {
    val sol = Solution1845()

    // 입출력 예시 데이터
    val test1 = intArrayOf(3, 1, 2, 3)
    val test2 = intArrayOf(3, 3, 3, 2, 2, 4)
    val test3 = intArrayOf(3, 3, 3, 2, 2, 2)

    // 실행 및 결과 확인
    println("테스트 1 (예상 2): ${sol.solution(test1)}")
    println("테스트 2 (예상 3): ${sol.solution(test2)}")
    println("테스트 3 (예상 2): ${sol.solution(test3)}")
}