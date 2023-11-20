package com.example.sharedviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

class MessageSenderFragment : Fragment() {


    lateinit var btn: Button


    lateinit var writeMSg: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn = view.findViewById(R.id.button)
        writeMSg = view.findViewById(R.id.writeMessage)


        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)


        btn.setOnClickListener { model.sendMessage(writeMSg.text.toString()) }
    }
}
