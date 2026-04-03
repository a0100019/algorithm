package com.a0100019.algorithm.programmers.normal

import java.util.*
import kotlin.math.ceil

class Solution92341 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        // 구조 분해 선언으로 요금표 정보 추출
        val (defaultMinute, defaultFee, addTime, addFee) = fees

        // 1. 입차 중인 차량의 입차 시간을 저장 (Key: 차량번호, Value: 입차 분)
        val carTime = mutableMapOf<String, Int>()

        // 2. 차량별 최종 누적 주차 시간을 저장 (Key: 차량번호, Value: 누적 분)
        // 차량번호 순으로 정렬하기 위해 TreeMap 사용
        val resultCarTime = mutableMapOf<String, Int>()

        for (record in records) {

            val (time, carNumber, state) = record.split(" ")

            val hourTime = time.split(":").first()
            val minuteTime = time.split(":").last()

            val totalMinute = hourTime.toInt() * 60 + minuteTime.toInt()

            if(state == "IN") {
                carTime[carNumber] = totalMinute
            } else {
                resultCarTime[carNumber] = resultCarTime.getOrDefault(carNumber, 0) -carTime.getOrDefault(carNumber, 0) + totalMinute
                carTime.remove(carNumber)
            }

        }

        // 3. 입차만 하고 출차 기록이 없는 차량 처리 (23:59 출차로 간주)
        for(car in carTime) {
            resultCarTime[car.key] = resultCarTime.getOrDefault(car.key, 0) - carTime.getOrDefault(car.key, 0) + 23 * 60 + 59
        }

        // 4. 최종 요금 계산 (TreeMap의 value들을 순회하면 차량번호 오름차순임)
        val sortedKeys = resultCarTime.keys.sorted()
        return sortedKeys.map {
            if(resultCarTime[it]!! <= defaultMinute) {
                defaultFee
            } else {
                (defaultFee + (resultCarTime[it]!! - defaultMinute + addTime - 1) / addTime * addFee)
            }
        }.toIntArray()

    }
}

/**
 * 테스트 실행을 위한 예시 함수 (Main)
 */
fun main() {
    val solution = Solution92341()

    // 예시 1 테스트
    val fees1 = intArrayOf(180, 5000, 10, 600)
    val records1 = arrayOf(
        "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
        "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
    )

    val result1 = solution.solution(fees1, records1)
    println("Test 1 Result: ${result1.contentToString()}")
    // 출력: [14600, 34400, 5000]
}