package chapter1_arrays_and_strings

fun main(args: Array<String>) {

}

class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        val n = matrix[0].size

        val row: MutableSet<Int> = mutableSetOf()
        val col: MutableSet<Int> = mutableSetOf()

        for (i in 0 until m) {
            for (j in 0 until n){
                if( matrix[i][j]==0){
                    row.add(i)
                    col.add(j)
                }
            }
        }

        row.forEach{ r->
            for (j in 0 until n){
                matrix[r][j] = 0
            }
        }

        col.forEach{ c->
            for (i in 0 until m){
                matrix[i][c] = 0
            }
        }
    }
}