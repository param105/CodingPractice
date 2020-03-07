package com.param.codingpractice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.param.codingpractice.MainListContent.MainListItem

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [MainListFragment.OnListFragmentInteractionListener] interface.
 */
class MainListFragment : Fragment()  {

    // TODO: Customize parameters
    private var columnCount = 1
    private var parentActivityListener: OnListFragmentInteractionListener? = null
    private var localListener: OnListFragmentInteractionListener? = null

    init {
        localListener = object : OnListFragmentInteractionListener {
            override fun onListFragmentInteraction(item: MainListItem?) {
                parentActivityListener?.onListFragmentInteraction(item)

                when(item?.id){
                    "0" -> findNavController().navigate(R.id.action_mainListFragment_to_serviceDemoFragment)
                    "1" -> findNavController().navigate(R.id.action_mainListFragment_to_intentServiceDemoFragment)
                    "2" -> findNavController().navigate(R.id.action_mainListFragment_to_messengerServiceFragment)
                    "3" -> findNavController().navigate(R.id.action_mainListFragment_to_notificationDemoFragment)
                }
            }
        };
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_main, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MainListRecyclerViewAdapter(MainListContent.ITEMS, localListener)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            parentActivityListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        parentActivityListener = null
    }


    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: MainListItem?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            MainListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
