import ru.maxbarannyk.helpers.WebSendHelper

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args : Array<String>) {
//    val t: Thread = object : Thread() {
//        override fun run() {
//            Thread.sleep(2000);
//            println("blah blah blah")
//            Thread.sleep(2000);
//            println("blah blah blah")
//        }
//    }
//    t.start()

//    val name = "Kotlin"
//    var name3: String? = null
//    name3 = "Kotlin3"
//    var x = 100 + 50
//    val myNum: Int = 5                // Int
//    val myDoubleNum: Double = 5.99    // Double
//    val myLetter: Char = 'D'          // Char
//    val myBoolean: Boolean = true     // Boolean
//    val myText: String = "Hello"      // String
//    var userData00 = UserData()
//    userData00.age = 18
//    userData00.email = "some@mail.com"
//    userData00.firstName = "Max"
//    userData00.lastName = "Mustermann"
//    println("userData00.firstName:" + userData00.firstName)

//    var userDataConstr00 = UserDataConstr("Max00", "Mustermann00", "some00@mail.com", 23)
//    println("userDataConstr00.firstName:" + userDataConstr00.firstName)
//    print("userDataConstr00.printUserData():")
//    println(userDataConstr00.toString())

    val webSender = WebSendHelper("https://api.maxbarannyk.ru/test-return-post", "testKey0001", "testValue0001")
    val innerResultBefore = webSender.getResult()
    println("innerResultBefore:" + innerResultBefore)
    webSender.start()
    webSender.join()
    val innerResult = webSender.getResult()
    println("innerResult:" + innerResult)
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.

//    println("x=" + x)
//    println("Hello, " + name3 + "!")

//    for (i in 1..5) {
//        println("i = $i")
//        Thread.sleep(1000);
//    }

}