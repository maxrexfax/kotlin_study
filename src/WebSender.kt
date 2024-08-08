class WebSender(result: String): Thread() {
    var _result: String
    init {
        _result = result
    }


    public override fun run() {
        println("${Thread.currentThread()} has run.")
        Thread.sleep(2000)
        this._result = "33333"
    }

    public fun getResult(): String {
        return this._result
    }
}