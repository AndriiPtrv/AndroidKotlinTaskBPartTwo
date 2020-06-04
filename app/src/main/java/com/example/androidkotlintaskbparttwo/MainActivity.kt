package com.example.androidkotlintaskbparttwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var products = Random.nextInt(1,10)
        val startProducts = products
        var addProducts: Int
        var buyProducts: Int
        number.text = products.toString()
        var textLog = StringBuffer("Log: \n Start value = $startProducts")
        log.text = textLog

        GlobalScope.launch {
            for (i in 0..100){
                delay(1500L)
                if (startProducts * 4 < products || startProducts <= 0) {cancel()}
                addProducts  = Random.nextInt(0,10)
                products += addProducts
                withContext(Dispatchers.Main) {
                    number.text = products.toString()
                    textLog.append("\n Added $addProducts items, now: $products")
                    log.text = textLog
                }
            }
        }

        GlobalScope.launch {
            for (i in 0..100){
                delay(1000L)
                if (startProducts * 4 < products || startProducts <= 0) {cancel()}
                buyProducts  = Random.nextInt(0,10)
                products += buyProducts
                withContext(Dispatchers.Main) {
                    number.text = products.toString()
                    textLog.append("\n Deleted $buyProducts items, now: $products")
                    log.text = textLog
                }
            }
        }
    }
}
