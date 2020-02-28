package com.param.codingpractice.servicedemo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.param.codingpractice.MainActivity
import com.param.codingpractice.R
import com.param.codingpractice.databinding.FragmentMessengerServiceBinding
import com.param.codingpractice.servicedemo.services.MessengerService
import java.lang.Exception
import java.lang.ref.WeakReference


class MessengerServiceFragment : Fragment() {

    private var TAG = "MessengerServiceFragment"
    private lateinit var binding: FragmentMessengerServiceBinding
    private lateinit var serviceConnection: ServiceConnection
    private lateinit var messengerService: MessengerService
    private var boundServiceMessenger :Messenger? = null
    private var localMessenger :Messenger? = null
    private var localHandler: LocalHandler? = null
    private var isServiceConnected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_messenger_service, container, false)
        initData()
        return binding.root
    }

    private fun initData() {
        localMessenger = Messenger(LocalHandler(this))
        val intentMessengerService = Intent(context,MessengerService::class.java)
        serviceConnection = object:ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                isServiceConnected = true
                boundServiceMessenger = Messenger(service)
                Log.d(TAG,"SERVICE CONNECTED / BOUND")
            }
            override fun onServiceDisconnected(name: ComponentName?) {
                isServiceConnected = false
                boundServiceMessenger = null
            }
        }

        binding.startButton.setOnClickListener{
            context?.startService(intentMessengerService)
        }

        binding.btnBind.setOnClickListener{
            context?.bindService(intentMessengerService,serviceConnection, Context.BIND_AUTO_CREATE)
        }

        binding.btnUnbind.setOnClickListener{
            context?.unbindService(serviceConnection)
        }

        binding.btnGetValue.setOnClickListener{
            if (isServiceConnected){
                try {
                    var message = Message.obtain(null, MessengerService.MSG_GET_TIMESTAMP,0,0)
                    message.replyTo = localMessenger
                    boundServiceMessenger?.send(message)

                }catch (e:RemoteException){
                    e.printStackTrace()
                }
            }

        }

        binding.btnStopService.setOnClickListener{
            if (isServiceConnected){
                isServiceConnected = false
                try {
                    activity?.unbindService(serviceConnection)
                }catch (e:Exception){e.printStackTrace()}

            }
            val intent = Intent(activity,MessengerService::class.java)
            activity?.stopService(intent)
        }


    }

    companion object {
        class LocalHandler(fragment: MessengerServiceFragment) : Handler() {
            var TAG =" LocalHandler"
            private var messengerServiceFragment  = WeakReference<MessengerServiceFragment>(fragment)
            override fun handleMessage(msg: Message) {
                when(msg.what){
                    MessengerService.MSG_GET_TIMESTAMP ->{

                        var timeStamp = msg.data.getString("timestamp")
                        Log.d(TAG,"Timestamp reply received from service -> $timeStamp")
                        messengerServiceFragment.get()?.binding?.tvLabel?.text = timeStamp

                    }
                }
            }

        }
    }

}


