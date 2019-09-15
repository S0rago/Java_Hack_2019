package com.firsttry.firsttry.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.firsttry.firsttry.R

class FindWorkFragment : Fragment() {

    private lateinit var findWorkViewModel : FindWorkViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        findWorkViewModel =
            ViewModelProviders.of(this).get(FindWorkViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_find_work, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        findWorkViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}