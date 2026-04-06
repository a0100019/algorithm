package com.a0100019.algorithm.programmers.matrix

class Solution12949 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {

        val arr1c = arr1.size
        val arr2r = arr2[1].size
        val arr1r = arr1[1].size

        val answer = Array(arr1c) { IntArray(arr2r)}

        for(i in 0 until arr1c) {
            for(j in 0 until arr2r) {
                for(k in 0 until arr1r) {

                    answer[i][j] += arr1[i][k]*arr2[k][j]

                }
            }
        }

        return answer
    }
}