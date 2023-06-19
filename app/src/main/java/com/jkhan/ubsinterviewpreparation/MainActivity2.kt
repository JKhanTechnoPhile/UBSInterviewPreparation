package com.jkhan.ubsinterviewpreparation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jkhan.ubsinterviewpreparation.api.Comment
import com.jkhan.ubsinterviewpreparation.api.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity2 : AppCompatActivity() {
    val TAG = MainActivity2::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
        GlobalScope.launch(Dispatchers.IO) {
//            val comments = api.getComments().await() // Return Expected Response ( List<Comment> )
//            for (comment in comments) {
//                Log.d(TAG, comment.toString())
//            }
//            val commentsResponse = api.getComments().awaitResponse() // need api call back as - Call<List<Comment>>
            val commentsResponse = api.getComments()
            if (commentsResponse.isSuccessful) {
                commentsResponse.body()?.let {
                    for (comment in it) {
                        Log.d(TAG, comment.toString())
                    }
                }
            }
        }
//        api.getComments().enqueue(object: Callback<List<Comment>> {
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        for (comment in it) {
//                            Log.d(TAG, comment.toString())
//                        }
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                Log.e(TAG, "Error: $t")
//            }
//        })
    }
}