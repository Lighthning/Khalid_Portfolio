package com.example.assignment04_task01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

private const val ARG_PARAM1 = "param1"

class FragmentOne : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1 = ArrayList<Items>()
    private lateinit var onClick:OnClick

    interface OnClick{
        fun ClickItem(url:String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelableArrayList<Items>(ARG_PARAM1) as ArrayList<Items>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_one, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.RecyclerViewOne)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val itemadapter = itemadapter(param1)
        recyclerView.adapter = itemadapter

        onClick = activity as OnClick

        itemadapter.onItemClick = {
            onClick.ClickItem(it.url)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: ArrayList<Items>) =
            FragmentOne().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PARAM1, param1)
                }
            }
    }
}