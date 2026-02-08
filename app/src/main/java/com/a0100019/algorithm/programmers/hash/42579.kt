package com.a0100019.algorithm.programmers.hash

class Solution42579 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val totalPlayMap = mutableMapOf<String, Int>()

        // 1. 장르별 총합 구하기 (작성하신 코드 활용)
        for (i in plays.indices) {
            totalPlayMap[genres[i]] = totalPlayMap.getOrDefault(genres[i], 0) + plays[i]
        }

        // 2. 총 재생 횟수 순으로 장르 정렬
        val genreOrder = totalPlayMap.toList().sortedByDescending { it.second }.map { it.first }

        // 3. 각 장르별로 노래 정렬 및 선택
        for (genre in genreOrder) {
            // 해당 장르의 (고유번호, 재생수) 리스트 생성
            val songs = genres.indices.filter { genres[it] == genre }
                .map { it to plays[it] } // Pair(index, playCount)

            // 정렬 조건 적용: 1순위 재생수(DESC), 2순위 고유번호(ASC)
            val sortedSongs = songs.sortedBy {it.first}.sortedByDescending{it.second}

            // 최대 2개까지 answer에 추가
            sortedSongs.take(2).forEach { answer.add(it.first) }
        }

        return answer.toIntArray()
    }
}

fun main() {
    val sol = Solution42579()

    // 입출력 예시 데이터
    val genres1 = arrayOf("classic", "pop", "classic", "classic", "pop")
    val plays1 = intArrayOf(500, 600, 150, 800, 2500)

    // 실행 및 결과 확인
    // 예상 결과: [4, 1, 3, 0]
    val result1 = sol.solution(genres1, plays1)
    println("테스트 1: ${result1.joinToString(", ")}")
}