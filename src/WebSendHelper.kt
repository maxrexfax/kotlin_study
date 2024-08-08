package ru.maxbarannyk.helpers

import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WebSendHelper(var urlString: String,
                    var propertyKey: String,
                    var propertyValue: String): Thread() {
    var _urlString = ""
    var _propertyKey: String
    var _propertyValue: String
    var _messageToSend = ""
    val helperClass = HelperClass()

    private var _result = "Empty"

    init {
        _urlString = urlString
        _propertyKey = propertyKey
        _propertyValue = propertyValue
        _messageToSend = propertyKey + propertyValue
    }


    fun getResult(): String {
        return this._result
    }

    public override fun run() {
        var connection: HttpURLConnection? = null
        //        String res = "Empty";
        try {
            //Create connection
            val url = URL(_urlString)
            println("Url to send: " + url.toString())
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "POST"
            connection.setRequestProperty(
                "Content-Type",
                "application/x-www-form-urlencoded"
            )
            helperClass.logString("WebSendHelper messageToSend:$_messageToSend")
            connection.setRequestProperty(
                "Content-Length",
                _messageToSend.toByteArray().size.toString()
            )
            connection.setRequestProperty("Content-Language", "en-US")

            connection.useCaches = false
            connection.doOutput = true

            //Send request
            val wr = DataOutputStream(
                connection.outputStream
            )
            wr.writeBytes(_messageToSend)
            wr.close()

            //Get Response
            val `is` = connection.inputStream
            val rd = BufferedReader(InputStreamReader(`is`))
            val response = StringBuilder() // or StringBuffer if Java version 5+
            var line: String?
            while ((rd.readLine().also { line = it }) != null) {
                response.append(line)
                response.append('\r')
            }
            rd.close()
            _result = response.toString()
            helperClass.logString("WebSendHelper got result:$_result")
        } catch (e: Exception) {
            e.printStackTrace()
            helperClass.logString("WebSendHelper Net send catch Exception:" + e.message)
        } finally {
            connection?.disconnect()
        }
    }


}