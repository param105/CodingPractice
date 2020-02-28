package com.param.codingpractice.servicedemo.services

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.content.Context
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder
import android.util.Log

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.param.myapplication.services.action.FOO"
private const val ACTION_BAZ = "com.param.myapplication.services.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.param.myapplication.services.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.param.myapplication.services.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class SimpleIntentService : IntentService("SimpleIntentService") {

    private var TAG = "SimpleIntentService";
    @Volatile
    private var serviceGlobalInt : Int = 0
    @Volatile
    private var isStopped :Boolean = false
    private var intentServiceBinder = IntentServiceBinder()

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"Intent service OnCreate..")
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG,"Intent service onBind..")
        return intentServiceBinder
    }

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_FOO -> {
                val param1 = intent.getIntExtra(EXTRA_PARAM1,1)
                val param2 = intent.getIntExtra(EXTRA_PARAM2,100)
                handleActionOne(param1, param2)
            }
            ACTION_BAZ -> {
                val param1 = intent.getIntExtra(EXTRA_PARAM1,1000)
                val param2 = intent.getIntExtra(EXTRA_PARAM2,1100)
                handleActionTwo(param1, param2)
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionOne(param1: Int, param2: Int) {
        for (i in param1..param2){
            if(!isStopped) {
            Thread.sleep(1000)
            serviceGlobalInt = i
            Log.d(TAG,"Action one ->$i")
            }else break
        }
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionTwo(param1: Int, param2: Int) {
        for (i in param1..param2){
            if(!isStopped) {
                Thread.sleep(1000)
                serviceGlobalInt = i
                Log.d(TAG, "Action Two ->$i")
            } else break
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Intent service destroyed..")
    }

    override fun onUnbind(intent: Intent?): Boolean {
         super.onUnbind(intent)
        Log.d(TAG,"Intent service onUnbind..")
        return true
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(TAG,"Intent service onRebind..")
    }

    fun getCurrentValue(): CharSequence? {
        return serviceGlobalInt.toString()
    }

    fun stopService(){
        isStopped = true
    }

    companion object {
        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun startActionOne(context: Context, param1: Int, param2: Int) {
            val intent = Intent(context, SimpleIntentService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }

        /**
         * Starts this service to perform action Baz with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun bindActionTwo(context: Context, param1: Int, param2: Int,serviceConnection: ServiceConnection) {
            val intent = Intent(context, SimpleIntentService::class.java).apply {
                action = ACTION_BAZ
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
            context.bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE)
        }
    }

    inner class IntentServiceBinder: Binder(){
        fun getService():SimpleIntentService{
            return this@SimpleIntentService
        }
    }
}
