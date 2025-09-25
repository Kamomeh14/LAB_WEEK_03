package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ListFragment : Fragment(), View.OnClickListener {

    private lateinit var coffeeListener: CoffeeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Memastikan activity induk mengimplementasikan interface
        if (context is CoffeeListener) {
            coffeeListener = context
        } else {
            throw RuntimeException("$context must implement CoffeeListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte)
        )

        coffeeList.forEach {
            it.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        v?.let {
            // Mengirim ID view yang di-klik ke activity melalui interface
            coffeeListener.onSelected(it.id)
        }
    }
}