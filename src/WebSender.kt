class WebSender: Thread() {
    var _result: String = "111"


    public override fun run() {
        println("${Thread.currentThread()} has run.")
        Thread.sleep(2000)
        this._result = "33333"
    }

    public fun getResult(): String {
        return this._result
    }
}