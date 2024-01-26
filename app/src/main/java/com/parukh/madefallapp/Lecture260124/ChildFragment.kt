package com.parukh.madefallapp.Lecture260124

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.parukh.madefallapp.R


class ChildFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    private lateinit var showDataTV:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val childView = inflater.inflate(R.layout.fragment_child, container, false)

        showDataTV = childView.findViewById(R.id.data_tv)
        return childView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDataTV.text = arguments?.getString("userData")?:"No Data Retrieved"
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            ChildFragment().apply {
                arguments = Bundle().apply {
                    putString("userData", param1)
                }
            }
    }
}