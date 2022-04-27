package com.adin.todolist.todo_list


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adin.todolist.databinding.TodoItemBinding


class TodoListAdapter(val clickListener: (TodoModel) -> Unit) :
    ListAdapter<TodoModel, TodoListAdapter.ViewHolder>(DIFF_CALLBACK) {
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

    inner class ViewHolder(
        private val binding: TodoItemBinding,
        private val listener: (TodoModel) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TodoModel) {
            binding.item = item
//            binding.lifecycleOwner = this@TodoListAdapter.activityLifecycle
            binding.executePendingBindings()
            val position = layoutPosition
            val element = getItem(position)
            binding.root.setOnClickListener {
                listener(element)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding, this@TodoListAdapter.clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}
