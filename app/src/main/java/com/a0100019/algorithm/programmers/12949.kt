package com.a0100019.algorithm.programmers

class Solution12949 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val r1 = arr1.size        // arr1의 행 개수
        val c1 = arr1[0].size     // arr1의 열 개수 (== arr2의 행 개수)
        val c2 = arr2[0].size     // arr2의 열 개수

        // 결과 행렬의 크기는 (arr1의 행) x (arr2의 열)
        val answer = Array(r1) { IntArray(c2) }

        for (i in 0 until r1) {           // 1. arr1의 행을 하나씩 선택
            for (j in 0 until c2) {       // 2. arr2의 열을 하나씩 선택
                for (k in 0 until c1) {   // 3. 곱해서 더할 원소들을 순회
                    answer[i][j] += arr1[i][k] * arr2[k][j]
                }
            }
        }

        return answer
    }
}