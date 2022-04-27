package com.adin.todolist.todo_list


import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adin.todolist.databinding.TodoItemBinding
import com.adin.todolist.todo_list.TodoListFragment.TodoModel


class TodoListAdapter() : ListAdapter<TodoModel, TodoListAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TodoModel>() {
            override fun areItemsTheSame(
                oldItem: TodoModel,
                newItem: TodoModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: TodoModel,
                newItem: TodoModel
            ): Boolean {
                return oldItem.completed == newItem.completed
            }
        }
    }


    inner class ViewHolder(private val binding: TodoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TodoModel) {
            binding.item = item
            if (item.completed) binding.tv.paintFlags =
                binding.tv.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
            else binding.tv.paintFlags =
                binding.tv.paintFlags and (Paint.STRIKE_THRU_TEXT_FLAG.inv())
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}
