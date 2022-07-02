package chapter1_arrays_and_strings

// 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
// cannot use additional data structures?
fun main(args: Array<String>){

    val uniqueString = "mynaeis1234"
    val notUniqueString = "mynameis1234"

//    runCode 1
    println("$uniqueString isUnique: ${runCode(uniqueString)}")
    println("$notUniqueString isUnique: ${runCode(notUniqueString)}")

//    runCode2
    println("$uniqueString isUnique: ${runCode2(uniqueString)}")
    println("$notUniqueString isUnique: ${runCode2(notUniqueString)}")


//    runCode3
    println("$uniqueString isUnique: ${runCode3(uniqueString)}")
    println("$notUniqueString isUnique: ${runCode3(notUniqueString)}")
}

// using an array to determine if something is new O(n)
private fun runCode(myString: String): Boolean{
    val list = MutableList(1000){false}

    myString.forEach { char ->
        if(list[char.code]) {
            return false
        } else {
            list[char.code] = true
        }
    }

    return true
}

// Convert to set and convert to list, then compare size O(n)
// this is just a concise way of doing
private fun runCode2(myString: String): Boolean{
    return myString.toList().size == myString.toSet().size
}

// Without even converting O(n^2)
// brute force
private fun runCode3(myString: String): Boolean{
    myString.forEachIndexed{ index, searchChar ->
        myString.substring(index+1 until myString.length).forEach { char ->
            if (searchChar == char) return false
        }
    }
    return true
}