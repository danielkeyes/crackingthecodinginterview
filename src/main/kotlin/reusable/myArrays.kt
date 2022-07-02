package reusable

class myArrays {
    companion object {
        fun createArray(row:Int,column:Int): Array<Array<Int>> {
            var count = 0

            val array = Array(row){ arrayOf(column) }

            for(i in 0 until row)
                for( j in 0 until column) {
                    array[i][j] = count
                    count++
                }

            return array
        }
    }
}

public fun Array<Array<Int>>.print(){
    for(i in 0 until this.size)
        println(this[i])
}