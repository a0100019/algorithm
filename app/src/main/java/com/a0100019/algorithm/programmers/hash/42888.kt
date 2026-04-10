package com.a0100019.algorithm.programmers.hash

class Solution42888 {
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()

        val nameMap = mutableMapOf<String, String>()

        for( i in record) {
            val recordArray = i.split(" ")

            if(recordArray[0] != "Leave") {
                nameMap[recordArray[1]] = recordArray[2]
            }

        }

        for( i in record) {
            val recordArray = i.split(" ")

            when(recordArray[0]) {
                "Enter" -> answer.add("${nameMap[recordArray[1]]}님이 들어왔습니다.")
                "Leave" -> answer.add("${nameMap[recordArray[1]]}님이 나갔습니다.")
            }
        }

        return answer.toTypedArray()
    }
}

fun main() {
    val sol = Solution42888()

    // 예시 1: 문제 지문에 나온 기본 시나리오
    val record1 = arrayOf(
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    )

    println("=== Test Case 1 ===")
    val result1 = sol.solution(record1)
    result1.forEach { println(it) }
    /*
     예상 결과:
     Prodo님이 들어왔습니다.
     Ryan님이 들어왔습니다.
     Prodo님이 나갔습니다.
     Prodo님이 들어왔습니다.
    */

    println("\n=== Test Case 2 (추가 케이스) ===")
    // 예시 2: 동일인이 여러 번 이름을 바꾸거나, 나간 상태에서 이름이 바뀌는 경우
    val record2 = arrayOf(
        "Enter uid0001 Alpha",
        "Enter uid0002 Beta",
        "Leave uid0001",
        "Change uid0002 Gamma",
        "Enter uid0001 Delta"
    )

    val result2 = sol.solution(record2)
    result2.forEach { println(it) }
    /*
     예상 결과:
     Delta님이 들어왔습니다.
     Gamma님이 들어왔습니다.
     Delta님이 나갔습니다.
     Delta님이 들어왔습니다.
    */
}