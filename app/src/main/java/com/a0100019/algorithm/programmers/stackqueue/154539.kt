class Solution154539 {

    fun solution(numbers: IntArray): IntArray {

        val array = IntArray(numbers.size) {-1}

        val deque = ArrayDeque<Int>()

        for(i in numbers.indices) {

            while(deque.isNotEmpty() && numbers[deque.last()] < numbers[i]) {

                array[deque.last()] = numbers[i]
                deque.removeLast()

            }

            deque.add(i)

        }

        return array
    }

}