package com.param.codingpractice.servicedemo

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.param.codingpractice.R
import com.param.codingpractice.databinding.FragmentIntentServiceDemoBinding
import com.param.codingpractice.servicedemo.services.SimpleIntentService
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [IntentServiceDemoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IntentServiceDemoFragment : Fragment() {


    private var TAG = "IntentServiceDemoFragment"
    private lateinit var binding: FragmentIntentServiceDemoBinding
    private lateinit var serviceConnection: ServiceConnection

    private var intentService: SimpleIntentService? = null
    private var param1: String? = null
    private var param2: String? = null

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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_intent_service_demo,container,false)
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        serviceConnection = object:ServiceConnection{
            override fun onServiceDisconnected(name: ComponentName?) {
                Log.d(TAG,"SERVICE DISCONNECTED / UNBOUND");
                binding.tvLabel.text = "SERVICE DISCONNECTED / UNBOUND"
            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                var binder = service as SimpleIntentService.IntentServiceBinder
                intentService = binder.getService()
                Log.d(TAG,"SERVICE CONNECTED / BOUND");
                binding.tvLabel.text = "SERVICE CONNECTED / BOUND"
            }

        }

        binding.startButton.setOnClickListener{
            SimpleIntentService.startActionOne(context!!,1,10)
        }

        binding.btnBind.setOnClickListener{
            SimpleIntentService.bindActionTwo(context!!,100,110,serviceConnection)
        }

        binding.btnGetValue.setOnClickListener{
            binding.tvLabel.text = intentService?.getCurrentValue()
        }

        binding.btnUnbind.setOnClickListener{
            try {
                context?.unbindService(serviceConnection)
            }catch (e:Exception){
                e.printStackTrace()
            }

        }

        binding.btnStopService.setOnClickListener{
            intentService?.stopService()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment IntentServiceDemoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IntentServiceDemoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
