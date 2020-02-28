package com.param.codingpractice.servicedemo.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

/***
 * simple service which has binding capabilities.
 * 1) When you start service by startService() method then it has to be stooped by stopSelf() or StopService()
 * 2) NOt started by startService() but service created with bound bindService() method
 *    then you have to unBind() it then only it will get destroyed
 * 3) started -> stopped // its valid
 * 4) started -> onBind() -> stopped // it not stop as it is now bounded
 * 5) started -> onBind() -> onUnbind() -> Stopeed() // it will destroy service
 * 5) bind -> unbind // will destroy service in this case also.
 */
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
        super.onUnbind(intent)
        return true
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(TAG,"Service Rebind..")
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
            stopSelf()
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
