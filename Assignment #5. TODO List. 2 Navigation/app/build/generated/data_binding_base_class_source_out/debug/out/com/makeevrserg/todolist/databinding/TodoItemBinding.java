// Generated by data binding compiler. Do not edit!
package com.makeevrserg.todolist.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.makeevrserg.todolist.R;
import com.makeevrserg.todolist.todo_list.TodoModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class TodoItemBinding extends ViewDataBinding {
  @Bindable
  protected TodoModel mItem;

  protected TodoItemBinding(Object _bindingComponent, View _root, int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setItem(@Nullable TodoModel item);

  @Nullable
  public TodoModel getItem() {
    return mItem;
  }

  @NonNull
  public static TodoItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.todo_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static TodoItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<TodoItemBinding>inflateInternal(inflater, R.layout.todo_item, root, attachToRoot, component);
  }

  @NonNull
  public static TodoItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.todo_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static TodoItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<TodoItemBinding>inflateInternal(inflater, R.layout.todo_item, null, false, component);
  }

  public static TodoItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static TodoItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (TodoItemBinding)bind(component, view, R.layout.todo_item);
  }
}
