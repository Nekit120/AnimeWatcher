package com.example.animewatcher.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.animewatcher.R

/**
 * A simple [Fragment] subclass.
 * Use the [ReleaseDateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReleaseDateFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_release_date, container, false)
    }


}