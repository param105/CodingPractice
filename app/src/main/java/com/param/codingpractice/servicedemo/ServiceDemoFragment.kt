package com.param.codingpractice.servicedemo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.param.codingpractice.R
import com.param.codingpractice.databinding.FragmentServiceBinding
import com.param.codingpractice.servicedemo.services.SimpleService

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ServiceDemoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ServiceDemoFragment : androidx.fragment.app.Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private  lateinit var binding: FragmentServiceBinding
    private lateinit var serviceConnection:ServiceConnection;
    var simpleService: SimpleService? = null;
    var serviceIntent:Intent? = null
    var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_service, container, false)
        initServiceConnection()
        setListeners()
        return binding.root
    }

    private fun initServiceConnection() {
         serviceConnection = object: ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                val binder = service as SimpleService.SimpleServiceBinder
                simpleService = binder.getService()
                isBound = true
                binding.tvLabel.text = "SERVICE CONNECTED";
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                isBound = false
                binding.tvLabel.text = "SERVICE DISCONNECTED";

            }
        }
    }

    private fun setListeners() {
        serviceIntent = Intent(activity, SimpleService::class.java)
        binding.startButton.setOnClickListener{
           activity?.startService(serviceIntent)
        }
        binding.btnBind.setOnClickListener{
            activity?.bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE)
        }

        binding.btnUnbind.setOnClickListener{
            if (isBound) {
                activity?.unbindService(serviceConnection)
            }
            isBound = false;
        }

        binding.btnGetValue.setOnClickListener{
            binding.tvLabel.text = simpleService?.getRandomNumber().toString()
        }

        binding.btnStopService.setOnClickListener{
            activity?.stopService(serviceIntent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ServiceDemoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ServiceDemoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



}
