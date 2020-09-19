import java.util.*
/*
fun main() {
    val example = Example()
    println("Enter first number: ")
    var num1 = Scanner(System.`in`).nextInt()
    println("Enter second number: ")
    var num2 = Scanner(System.`in`).nextInt()
    example.multiplicaiton(num1,num2,object :MyInterface{         //
        override fun multiple(result: Int) {
            println("1.Answer = $result")
        }
    })
    example.multiplicaiton(num1,num2,{num1,num2->num1*num2})           //
    println("Enter first number: ")
    var number1 = Scanner(System.`in`).nextInt()
    println("Enter second number: ")
    var number2 = Scanner(System.`in`).nextInt()
    example.multiplicaiton(number1,number2,{result -> println("3.Answer = $result")})   //
    var result = 0
    println("Enter first number: ")
    var _num1 = Scanner(System.`in`).nextInt()
    println("Enter second number: ")
    var _num2 = Scanner(System.`in`).nextInt()
    example.multiplicaiton(_num1,_num2){num1,num2->result = num1 * num2}
    println("Answer = $result")
    println("=================================")
    var reverse = Reversed()
    reverse.reverseeAndDisplay("Tohir",{it.reversed()})
}

class Example{
    fun multiplicaiton(num1:Int,num2:Int,function:MyInterface){
        function.multiple(num1 * num2)
    }

    }
class Reversed{
    fun reverseeAndDisplay(name:String,myFunction:(String)->String){
        println("Reversed = ${myFunction(name).toLowerCase()}")
    }

    fun multiplicaiton(num1:Int,num2:Int,function:(Int,Int)->Int) {
        println("2.Answer = ${function(num1,num2)}")
    }

    fun multiplicaiton(num1:Int,num2:Int,function:(Int)->Unit) {
        function(num1 * num2)
    }

    fun multiplicaiton(num1:Int,num2:Int,function:(Int,Int)->Unit) {
      function(num1,num2)
    }


interface MyInterface{
    fun multiple(result:Int)
}

*/


fun main() {
    var program = Program()
    program.addNumbers(7,9,object : MyInterface{     //calling with using interfave
        override fun adding(sum: Int) {
            println("Sum with interface = $sum")
        }
    })

     program.addNumbers(7,9,{num-> println("Sum with lambda = $num")} )  //calling lambda function

    // val answer:(Int,Int)->Int = {num1,num2->num1+num2}

    program.addNumbers(7,9,{num1,num2->num1 + num2}) //Passing Lambda to high level function
}

class Program{
    fun addNumbers(num1:Int,num2:Int,action: (Int) -> Unit){   //high level function with lambda as parameters
        val answer = num1 + num2
        action(answer) //prinln(num)
    }

    fun addNumbers(num1:Int,num2:Int,action: (Int,Int) -> Int){   //high level function with lambda as parameters
        val answer = action(num1,num2)
        println("Sum with passing lampda $answer") //prinln(num)
    }

    fun addNumbers(num1:Int,num2:Int,action:MyInterface){      //using interface
        val answer = num1 + num2
        action.adding(answer)
    }
}

interface MyInterface{
    fun adding(sum:Int)
}
/*
fun main() {
    var smth = Smth()
    smth.session()
    smth.nothing
    var person = Person()
    person.name = "Tohir"
    println("Salom ${person.name}")
}

interface Inter{
    val nothing:String
    fun session():String
}
class Smth():Inter{
    override val nothing: String
    get() = "Salom"
    override fun session(): String {
        return "Salom"
    }
}

class Person {
    var name: String = "defaultValue"

        // getter
        get() = field

        // setter
        set(value) {
            field = value
        }
}*/