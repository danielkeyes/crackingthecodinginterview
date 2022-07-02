package chapter1_arrays_and_strings

import reusable.println

fun main(args: Array<String>) {
    val s1 = "aaabcccddddd"
    val s2 = "aabbccdd"
    val s3 = "animal"

    compress(s1).println()
    compress(s2).println()
    compress(s3).println()
}

private fun compress(s: String): String {
    if(s.length <2){
        return s
    }

    var char = s[0]
    var count = 1
    val sb = StringBuilder()

    for(i in 1 until s.length){
        if(char==s[i]) {
            count++
        } else {
            sb.append("$char$count")
            char = s[i]
            count=1
        }
    }

    sb.append("$char$count")

    var compressedString = sb.toString()

    return if(s.length <= compressedString.length) {
        s
    } else {
        compressedString
    }
}