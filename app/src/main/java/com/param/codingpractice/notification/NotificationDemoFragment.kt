package com.param.codingpractice.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.param.codingpractice.R
import com.param.codingpractice.databinding.FragmentNotificationDemoBinding


class NotificationDemoFragment : Fragment() {

        private val TOPIC = "breakfast"

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            val binding: FragmentNotificationDemoBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_notification_demo, container, false
            )

            val viewModel = ViewModelProviders.of(this)
                .get(EggTimerViewModel::class.java)

            binding.eggTimerViewModel = viewModel
            binding.lifecycleOwner = this.viewLifecycleOwner


            createChannel(
                getString(R.string.egg_notification_channel_id),
                getString(R.string.egg_notification_channel_name)
            )

            return binding.root
        }

        private fun createChannel(channelId: String, channelName: String) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel = NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_HIGH
                )

                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.RED
                notificationChannel.enableVibration(true)
                notificationChannel.description = getString(R.string.breakfast_notification_channel_description)

                val notificationManager = requireActivity().getSystemService(
                    NotificationManager::class.java
                )
                notificationManager?.createNotificationChannel(notificationChannel)

            }
        }

    }