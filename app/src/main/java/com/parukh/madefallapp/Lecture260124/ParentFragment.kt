package com.parukh.madefallapp.Lecture260124

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.parukh.madefallapp.R


class ParentFragment : Fragment() {

    private lateinit var mCommunicator: Communicator
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is Communicator)
        {
            mCommunicator = context
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var getNameET:EditText
    private lateinit var sendDataBtn:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parentView =inflater.inflate(R.layout.fragment_parent, container, false)

        getNameET = parentView.findViewById(R.id.parentf_name_et)
        sendDataBtn = parentView.findViewById(R.id.parentf_send_data_btn)

        return parentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendDataBtn.setOnClickListener {
            if(getNameET.text.isNotEmpty())
            {
                mCommunicator.sendData(getNameET.text.toString())
            }
            else
            {
                Toast.makeText(context,"Please enter the data",Toast.LENGTH_LONG).show()
                getNameET.requestFocus()
            }
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ParentFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}