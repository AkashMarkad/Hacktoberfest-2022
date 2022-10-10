fun main() {
    val listOfInt = listOf(1,2,3,null,5,null,7) // list number from 1 s/d 7 with null value

    for (i in listOfInt){
        if (i == null) continue // null is skip
        print(i) // 12357
    }
    println()

    for (i in listOfInt){
        if (i == null) break
        print(i) // 123
    }
    println("\n")

    loop@for (i in 1.rangeTo(10)){ // with lable loop@
        println("Outside Loop")
        println("=-=-=--=-=-=")
        for(j in 1.rangeTo(10)){
            println("Inside Loop")
            if(j > 5) break@loop // close lable and stop looping outside if j > 5
        }
    }
}