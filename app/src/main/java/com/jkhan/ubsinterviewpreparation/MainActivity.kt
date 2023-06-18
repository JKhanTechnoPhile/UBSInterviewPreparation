package com.jkhan.ubsinterviewpreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.jkhan.ubsinterviewpreparation.security.CryptoManager
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

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
            val messageToEncrypt = editText.text.toString().encodeToByteArray()
            val file = File(filesDir, "secret.txt")
            if (!file.exists()) {
                file.createNewFile()
            }
            val fos = FileOutputStream(file)
            messageToDecrypt = cryptoManager.encrypt(
                bytes = messageToEncrypt,
                outputStream = fos
            )
            messageToDecryptAsString = messageToDecrypt.decodeToString()
        }

        findViewById<AppCompatButton>(R.id.decrypt_btn).setOnClickListener {
            val file = File(filesDir, "secret.txt")
            messageToEncrypt = cryptoManager.decrypt(
                inputStream = FileInputStream(file)
            ).decodeToString()
            editText.setText(messageToEncrypt)
        }
    }
}