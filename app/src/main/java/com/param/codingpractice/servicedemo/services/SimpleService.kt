package com.param.codingpractice.servicedemo.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class SimpleService : Service() {

    @Volatile
    private var serviceRandom : Int = 0

    @Volatile
    private var isStopped :  Boolean = false
    private var TAG = "SimpleService";
    private var simpleServiceBinder: SimpleServiceBinder = SimpleServiceBinder()
    private lateinit var serviceThread :Thread

    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG,"Service onBind")
        return simpleServiceBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG,"Service onUnbind..")
        return super.onUnbind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)
        return Service.START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"Service created and thread started..")

        serviceThread = Thread(Runnable {
            for (i in 1..100){
                if (!isStopped) {
                    try {
                        Thread.sleep(1000)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    serviceRandom = i
                    Log.d(TAG, "Service Random - $serviceRandom")
                }
            }
        })
        serviceThread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Service destroyed..")
        isStopped = true
    }

    fun getRandomNumber(): Int {
        return serviceRandom
    }

    fun getCurrentTime(): String {
        val dateformat = SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
            Locale.ENGLISH)
        return dateformat.format(Date())
    }

    inner class SimpleServiceBinder : Binder() {
        fun getService(): SimpleService {
            return this@SimpleService
        }

    }
}
