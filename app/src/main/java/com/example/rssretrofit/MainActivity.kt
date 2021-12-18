package com.example.rssretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.rssretrofit.Model.RSS
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory



class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    private  val BASE_URL = "https://news.google.com/"
    lateinit var tvTitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTitle = findViewById(R.id.tvTitle)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val feedAPI = retrofit.create(APIInterface::class.java)
        val call = feedAPI.feed

                call!!.enqueue(object : Callback<RSS?> {
                    override fun onResponse(call: Call<RSS?>, response: Response<RSS?>) {

                        val channel = response.body()!!.channel
                        val items= channel!!.item
                        for (item in items!!) {

                            var text = tvTitle.text.toString()
                            tvTitle.text = text + "\n The Title:" + item.title+"\n " +
                                    "The Source:"+item.source+"\n"
                        }
                    }

                    override fun onFailure(call: Call<RSS?>, t: Throwable) {
                        Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.message)
                        Toast.makeText(this@MainActivity, "An Error Occurred", Toast.LENGTH_SHORT).show()
                    }
                })
            }
    }

