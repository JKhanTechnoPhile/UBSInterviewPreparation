package com.jkhan.ubsinterviewpreparation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.lifecycleScope
import com.jk.fib
import com.jkhan.ubsinterviewpreparation.security.CryptoManager
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    private lateinit var editText: AppCompatEditText
    private lateinit var cryptoManager: CryptoManager
    private lateinit var messageToDecrypt: ByteArray
    private lateinit var messageToEncrypt: String
    private lateinit var messageToDecryptAsString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cryptoManager = CryptoManager()

        editText = findViewById(R.id.edit_text)

        findViewById<AppCompatButton>(R.id.encrypt_btn).setOnClickListener {
//            val messageToEncrypt = editText.text.toString().encodeToByteArray()
//            val file = File(filesDir, "secret.txt")
//            if (!file.exists()) {
//                file.createNewFile()
//            }
//            val fos = FileOutputStream(file)
//            messageToDecrypt = cryptoManager.encrypt(
//                bytes = messageToEncrypt,
//                outputStream = fos
//            )
//            messageToDecryptAsString = messageToDecrypt.decodeToString()

//            lifecycleScope.launch {
//                while (true) {
//                    delay(1000L)
//                    Log.d(TAG, "Still running...")
//                }
//            }

            lifecycleScope.launch {
//                delay(5000L)
                Intent(this@MainActivity, MainActivity2::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        findViewById<AppCompatButton>(R.id.decrypt_btn).setOnClickListener {
            val file = File(filesDir, "secret.txt")
            messageToEncrypt = cryptoManager.decrypt(
                inputStream = FileInputStream(file)
            ).decodeToString()
            editText.setText(messageToEncrypt)
            Log.d(TAG, "Decrypted message from crypto manager: $messageToEncrypt")
        }
        /*
            One thread can have multiple coroutines, when coroutine is suspended thread is not blocked only that particular coroutine will be paused
            If main thread or application is closed then all the coroutines will be cancelled even if it is mentioned as global scope
            Suspend function can be called inside coroutine or another suspend function
         */
//        GlobalScope.launch {
//            delay(5000L) // Will pause only coroutine and it will not block main thread
//            Log.d(TAG, "GlobalScope.launch block: ${Thread.currentThread().name}")
//        }
//        Log.d(TAG, "onCreate block: ${Thread.currentThread().name}")

//        GlobalScope.launch(newSingleThreadContext("MyThread")) {
//            withContext(Dispatchers.IO) {
//
//            }
//        }
//        GlobalScope.launch(Dispatchers.Main) {
//
//        }
//        Make API call one after the other
//        CoroutineScope(Dispatchers.IO).launch {
//            val networkCall1Response = doNetworkCall1()
//            val networkCall2Response = doNetworkCall2()
//            Log.d(TAG, "networkCall1Response: $networkCall1Response")
//            Log.d(TAG, "networkCall2Response: $networkCall2Response")
//        }
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val deferred1 =  async { doNetworkCall1() }
//            val deferred2 =  async { doNetworkCall2() }
//
//            val networkCall1Response = deferred1.await()
//            val networkCall2Response = deferred2.await()
//            Log.d(TAG, "networkCall1Response: $networkCall1Response")
//            Log.d(TAG, "networkCall2Response: $networkCall2Response")
//        }
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val deferreds = listOf(
//                async { doNetworkCall1() },
//                async { doNetworkCall2() }
//            )
//            deferreds.awaitAll()
//
//            val networkCall1Response = deferreds[0].await()
//            val networkCall2Response = deferreds[0].await()
//            Log.d(TAG, "networkCall1Response: $networkCall1Response")
//            Log.d(TAG, "networkCall2Response: $networkCall2Response")
//        }
//        MainScope().launch(Dispatchers.Default) {
//
//        }
//        lifecycleScope.launch(handler) {
//            throw Exception("Error")
//        }
//        CoroutineScope will cancels all coroutines even one coroutine fails, to handle that put all the child coroutines under supervisor scope
//        CoroutineScope(Dispatchers.Main + handler).launch {
//            supervisorScope {
//                launch {
//                    delay(300L)
//                    throw Exception("Coroutine 1 failed")
//                }
//
//                launch {
//                    delay(400L)
//                    println("Coroutine 2 finished")
//                }
//            }
//        }

    }

    val handler = CoroutineExceptionHandler {_ , throable ->
        Log.d(TAG, "Caught exception: $throable")
    }

    suspend fun doNetworkCall1(): String {
        delay(3000L)
        return "doNetworkCall1"
    }

    suspend fun doNetworkCall2(): String {
        delay(3000L)
        return "doNetworkCall2"
    }
}