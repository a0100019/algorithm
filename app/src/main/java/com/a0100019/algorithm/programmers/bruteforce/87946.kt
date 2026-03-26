package com.a0100019.algorithm.programmers.bruteforce

class Solution87946 {
    // 탐험할 수 있는 최대 던전 수를 저장할 전역 변수
    var maxDungeons = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        // 1. 각 던전의 방문 여부를 저장할 BooleanArray를 만듭니다. (dungeons.size만큼)
        val visited = BooleanArray(dungeons.size)

        // 2. DFS 탐색을 시작합니다. (현재 피로도, 던전 배열, 방문 배열, 현재까지 탐험한 수)
        dfs(k, dungeons, visited, 0)

        return maxDungeons
    }

    private fun dfs(currentK: Int, dungeons: Array<IntArray>, visited: BooleanArray, count: Int) {
        // 3. 현재까지 탐험한 수(count)와 기존의 maxDungeons 중 큰 값을 저장합니다.
         maxDungeons = maxOf(maxDungeons, count)

        // 4. 반복문을 통해 모든 던전을 확인합니다.
        for (i in dungeons.indices) {
            // 5. 조건 확인:
            // - 이 던전을 아직 방문하지 않았는가? (!visited[i])
            // - 현재 남은 피로도(currentK)가 이 던전의 "최소 필요 피로도"(dungeons[i][0]) 이상인가?

            if (!visited[i] && currentK >= dungeons[i][0]) {
                // 6. 방문 처리 (visited[i] = true)
                visited[i] = true

                // 7. 재귀 호출: 다음 던전을 탐색합니다.
                // - 피로도는 현재 피로도에서 "소모 피로도"(dungeons[i][1])를 뺀 값을 넘깁니다.
                // - 탐험 횟수는 count + 1을 넘깁니다.
                dfs(currentK - dungeons[i][1], dungeons, visited, count +1)

                // 8. 백트래킹(Backtracking): 다른 경로 탐색을 위해 방문 처리를 다시 해제합니다.
                // (visited[i] = false)
                visited[i] = false
            }
        }
    }
}
/**
 * 테스트를 위한 메인 함수
 */
fun main() {
    val sol = Solution87946()

    val k = 80
    val dungeons = arrayOf(
        intArrayOf(80, 20),
        intArrayOf(50, 40),
        intArrayOf(30, 10)
    )

    val result = sol.solution(k, dungeons)
    println("최대 탐험 가능 던전 수: $result (정답: 3)")
}