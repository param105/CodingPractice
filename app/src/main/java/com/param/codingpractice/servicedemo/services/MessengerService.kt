package com.param.codingpractice.servicedemo.services

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log
import android.widget.Chronometer
import java.lang.Exception
import java.lang.ref.WeakReference


class MessengerService : Service() {

    private var TAG = "MessengerService"
    private lateinit var messanger: Messenger
    private var mChronometer: Chronometer? = null
    companion object {
        const val MSG_GET_TIMESTAMP = 1000
    }

    override fun onCreate() {
        Log.d(TAG, "MessengerService onCreate")
        messanger = Messenger(MessageHandler(this))
        mChronometer = Chronometer(this);
        mChronometer?.setBase(SystemClock.elapsedRealtime())

        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "MessengerService onBind")
        return messanger.binder
    }

    override fun onRebind(intent: Intent?) {
        Log.d(TAG, "MessengerService onReBind")
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "MessengerService onUnBind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.d(TAG, "MessengerService onDestroy")
        super.onDestroy()
    }

    inner class MessageHandler(messengerService: MessengerService) : Handler() {
        var service: WeakReference<MessengerService> =
            WeakReference<MessengerService>(messengerService)

        /***
         * handles message sent form other class
         */
        override fun handleMessage(msg: Message) {

            when (msg.what) {
                Companion.MSG_GET_TIMESTAMP -> {
                    Log.d(TAG,"Timestamp request received...");

                    val elapsedMillis = SystemClock.elapsedRealtime()
                    service.get()?.mChronometer?.getBase();
                    val hours = (elapsedMillis / 3600000);
                    val minutes = (elapsedMillis - hours * 3600000) / 60000;
                    val seconds = (elapsedMillis - hours * 3600000 - minutes * 60000) / 1000;
                    val millis = (elapsedMillis - hours * 3600000 - minutes
                            * 60000 - seconds * 1000);
                    val activityMessenger = msg.replyTo;
                    val b = Bundle();
                    b.putString("timestamp", " $hours : $minutes : $seconds : $millis");
                    val replyMsg = Message.obtain(null, Companion.MSG_GET_TIMESTAMP);
                    replyMsg.data = b;
                    try {
                        activityMessenger.send(replyMsg);
                        Log.d(TAG,"Timestamp message sent...");
                    } catch (e: Exception) {
                        e.printStackTrace();

                    }
                }
                else -> super.handleMessage(msg)

            }
        }
    }


}
