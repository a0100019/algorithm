package com.example.algorithm.programmers.dfs

class Solution43165 {
    // 타겟 넘버를 만든 방법의 수를 저장할 변수
    var count = 0

    fun solution(numbers: IntArray, target: Int): Int {
        // 1. 카운트를 0으로 초기화 (여러 번 실행될 경우를 대비)
        count = 0

        // 2. DFS 탐색 시작
        // (숫자 배열, 타겟 값, 현재 인덱스, 현재까지의 합계)
        dfs(numbers, target, 0, 0)

        return count
    }

    private fun dfs(numbers: IntArray, target: Int, index: Int, currentSum: Int) {
        // 3. 종료 조건 확인: 모든 숫자를 다 사용했는가? (index == numbers.size)
        if (index == numbers.size) {
            // 4. 조건 확인: 현재까지의 합(currentSum)이 타겟(target)과 같은가?
            // - 같다면 count를 1 증가시킵니다.

            if(currentSum == target) {
                count++
            }

            return // 탐색 종료
        }

        // 5. 재귀 호출 (두 가지 갈래길):
        // - 현재 숫자(numbers[index])를 더하는 경우
        // - 현재 숫자(numbers[index])를 빼는 경우

        dfs(numbers, target, index + 1, currentSum + numbers[index])

        dfs(numbers, target, index + 1, currentSum - numbers[index])
    }
}

/**
 * 안드로이드 스튜디오나 로컬 JVM에서 실행 확인을 위한 메인 함수
 */
fun main() {
    val sol = Solution43165()

    // 테스트 케이스 1
    val numbers1 = intArrayOf(1, 1, 1, 1, 1)
    val target1 = 3
    println("결과 1: ${sol.solution(numbers1, target1)} (정답: 5)")

    // 테스트 케이스 2
    val numbers2 = intArrayOf(4, 1, 2, 1)
    val target2 = 4
    println("결과 2: ${sol.solution(numbers2, target2)} (정답: 2)")
}