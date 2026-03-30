package com.a0100019.algorithm.programmers

class Solution12985 {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var aa = a
        var bb = b

        // a와 b가 같아진다는 것은 "같은 대진표에 배정되었다"는 뜻입니다.
        while (aa != bb) {
            // 1. 다음 라운드 번호로 갱신 (핵심 공식)
            aa = (aa + 1) / 2
            bb = (bb + 1) / 2

            // 2. 라운드 횟수 증가
            answer++
        }

        return answer
    }
}