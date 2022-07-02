package chapter1_arrays_and_strings

fun main(args: Array<String>) {
    val s1 = "daniel leinad"
    val s2 = "danielleinad"
    val s3 = "sdasdasdasdas"

    println(isPalindrome(s1))
    println(isPalindrome(s2))
    println(isPalindrome(s3))
}

fun isPalindrome(s: String):Boolean {
    for(i in 0..(s.length/2)){
        if(s[i] != s[s.length-1-i]) return false
    }

    return true
}