package com.a0100019.algorithm.programmers.hash

class Solution42577 {
    fun solution(phone_book: Array<String>): Boolean {

//        val set = mutableSetOf<String>()
//        for(i in phone_book) {
//            set.add(i)
//        }
        val set = phone_book.toHashSet()

        for(phone in phone_book) {
            for(i in 1 until phone.length) {
                val string = phone.substring(0, i)
                if(set.contains(string)) return false
            }
        }


        return true
    }
}

fun main() {
    val sol = Solution42577()

    // 입출력 예시 데이터
    val test1 = arrayOf("119", "97674223", "1195524421")
    val test2 = arrayOf("123", "456", "789")
    val test3 = arrayOf("12", "123", "1235", "567", "88")

    // 실행 및 결과 확인
    println("테스트 1 (예상 false): ${sol.solution(test1)}")
    println("테스트 2 (예상 true): ${sol.solution(test2)}")
    println("테스트 3 (예상 false): ${sol.solution(test3)}")
}