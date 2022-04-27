package com.adin.todolist.todo_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.adin.todolist.R
import com.adin.todolist.databinding.TodolistFragmentBinding
import com.adin.todolist.databinding.TodolistFragmentBindingImpl
import java.util.*
import kotlin.random.Random

class TodoListFragment : Fragment() {
    data class TodoModel(
        val id: Long = 0,
        val text: String = "",
        val completed: Boolean = false
    )

    private val viewModel: TodoListViewModel by lazy {
        ViewModelProvider(this)[TodoListViewModel::class.java]
    }
    val adapter by lazy {
        TodoListAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: TodolistFragmentBindingImpl = DataBindingUtil.inflate(
            inflater,
            R.layout.todolist_fragment, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerView.adapter = adapter
        adapter.submitList(IntRange(0, 123).map {
            TodoModel(
                text = UUID.randomUUID().toString(),
                completed = Random.nextBoolean()
            )
        })
        return binding.root
    }
}