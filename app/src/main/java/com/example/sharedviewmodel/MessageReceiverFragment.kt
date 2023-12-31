package com.example.sharedviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MessageReceiverFragment : Fragment() {

    lateinit var displayMsg: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_message_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayMsg = view.findViewById(R.id.textViewReceiver)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        model.message.observe(viewLifecycleOwner, Observer {

            displayMsg.text = it
        })
    }
}
