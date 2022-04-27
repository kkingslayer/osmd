package com.adin.todolist.item_detail_fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.adin.todolist.R

class ItemDetailFragment : Fragment() {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = ItemDetailFragmentArgs.fromBundle(requireArguments())
        val text = view.findViewById<TextView>(R.id.tvDetail)
        text.text = arguments.text
    }
}