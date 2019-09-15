package com.firsttry.firsttry.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.firsttry.firsttry.R

class AnalyticsFragment : Fragment() {

    private lateinit var analyticsFragment : AnalyticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        analyticsFragment =
            ViewModelProviders.of(this).get(AnalyticsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_analytics, container, false)
        val textView: TextView = root.findViewById(R.id.text_analytics)
        analyticsFragment.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}