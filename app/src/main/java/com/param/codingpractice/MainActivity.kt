package com.param.codingpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.param.codingpractice.MainListFragment.OnListFragmentInteractionListener
import com.param.codingpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnListFragmentInteractionListener {

    var TAG = "MainActivity"
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }

    override fun onListFragmentInteraction(item: MainListContent.MainListItem?) {
     Log.d(TAG,"clicked item is - "+item?.content)

    }
}