object Main extends App{
    //ex 1
    var names: List[String] = List("Justin","Paul","David","Eugenie")

    //ex2
    println(names.mkString(", "))

    //ex3
    if(names.contains("Paul")){
        println("Paul is on the list.")
    }else{
        println("Paul is not on the list.")
    }

    //ex4
    var betterNames: List[String] = names.filterNot(_ == "Paul")

    //ex5
    println(betterNames.mkString(", "))
}
