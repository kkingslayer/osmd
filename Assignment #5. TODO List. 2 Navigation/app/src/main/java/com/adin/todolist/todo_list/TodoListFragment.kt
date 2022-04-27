package com.adin.todolist.todo_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.adin.todolist.R
import com.adin.todolist.databinding.TodolistFragmentBinding
import java.util.*
import kotlin.random.Random

data class TodoModel(
    val id: Long = 0,
    val text: String = "",
    val completed: Boolean = false
)

class TodoListFragment : Fragment() {
    private val viewModel: TodoListViewModel by lazy {
        ViewModelProvider(this)[TodoListViewModel::class.java]
    }
    val adapter by lazy {
        TodoListAdapter() {item ->
            findNavController().navigate(
                TodoListFragmentDirections.actionTodolistFragmentToItemDetailFragment(item.text)
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: TodolistFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.todolist_fragment, container, false
        )
        binding.button.setOnClickListener {
            findNavController().navigate(
                TodoListFragmentDirections.actionTodolistFragmentToAddItemFragment()
            )
        }
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