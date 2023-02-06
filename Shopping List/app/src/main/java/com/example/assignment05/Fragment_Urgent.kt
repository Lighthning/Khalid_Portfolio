package com.example.assignment05

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment_Urgent : Fragment() {
    private var param1 = ArrayList<items>()
    private var urgarray = ArrayList<items>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment__urgent, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerviewurgent)
        val dbHelper = context?.let { DBHelper(it) }
        param1 = dbHelper!!.getallitems()
        for (a in param1){
            if (a.img == R.drawable.urgent){
                urgarray.add(a)
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        val itemadapter = itemadapter(urgarray)
        recyclerView.adapter = itemadapter

        itemadapter.onItemClick = {
            val intent = Intent(context, MainActivity3::class.java)
            intent.putExtra("display", it)
            startActivity(intent)
        }

        itemadapter.onItemLongClick = {
            val dialogBuilder = AlertDialog.Builder(requireContext())
            dialogBuilder.setMessage("Are you sure you want to delete ${it.name} from the list?")
                .setPositiveButton("DELETE", DialogInterface.OnClickListener{ dialog, id ->
                    dbHelper.deleteitems(it.id)
                    urgarray.remove(it)
                    val itemadapter = itemadapter(urgarray)
                    recyclerView.adapter = itemadapter
                })
                .setNegativeButton("CANCEL", DialogInterface.OnClickListener{ dialog, id ->dialog.cancel()})
            val alert = dialogBuilder.create()
            alert.setTitle("Delete Item")
            alert.show()
        }

        return view
    }
}