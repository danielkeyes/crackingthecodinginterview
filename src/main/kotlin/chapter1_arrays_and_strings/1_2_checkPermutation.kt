package chapter1_arrays_and_strings

fun main(args: Array<String>){
    println(isPermutation("loans","alson"))
    println(isPermutation("loans","also"))

    println(isPermutation2("loans","alson"))
    println(isPermutation2("loans","also"))
    println(isPermutation2("eeeeeellllll","lllllleeeeee"))
}

// Simple kotlin method, not going to be performant
private fun isPermutation(string1: String, string2: String): Boolean {
    return string1.toList().sorted() == string2.toList().sorted()
}

private fun isPermutation2(s1: String, s2: String): Boolean {
    if (s1.length != s2.length)  return false // if not equal length can't be permutation

    var totalCount = 0

    s1.forEach { c ->
        var count1 = 0
        var count2 = 0

        s1.forEach { c1 ->
            if (c1 == c) count1++
        }
        s2.forEach { c2 ->
            if (c2 == c) count2++
        }

        if (count1 != count2) {
            return false
        }
        else { //useful if expect tons of duplicates
            totalCount += count1
            if (totalCount == s1.length)
                return true
        }
    }
    return true // never get here because of the last else
}