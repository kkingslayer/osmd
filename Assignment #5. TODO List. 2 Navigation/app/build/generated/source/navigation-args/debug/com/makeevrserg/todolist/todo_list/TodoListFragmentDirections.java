package com.makeevrserg.todolist.todo_list;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.makeevrserg.todolist.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class TodoListFragmentDirections {
  private TodoListFragmentDirections() {
  }

  @NonNull
  public static ActionTodolistFragmentToItemDetailFragment actionTodolistFragmentToItemDetailFragment(
      @NonNull String text) {
    return new ActionTodolistFragmentToItemDetailFragment(text);
  }

  @NonNull
  public static NavDirections actionTodolistFragmentToAddItemFragment() {
    return new ActionOnlyNavDirections(R.id.action_todolist_fragment_to_addItemFragment);
  }

  public static class ActionTodolistFragmentToItemDetailFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionTodolistFragmentToItemDetailFragment(@NonNull String text) {
      if (text == null) {
        throw new IllegalArgumentException("Argument \"text\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("text", text);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionTodolistFragmentToItemDetailFragment setText(@NonNull String text) {
      if (text == null) {
        throw new IllegalArgumentException("Argument \"text\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("text", text);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("text")) {
        String text = (String) arguments.get("text");
        __result.putString("text", text);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_todolist_fragment_to_itemDetailFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getText() {
      return (String) arguments.get("text");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionTodolistFragmentToItemDetailFragment that = (ActionTodolistFragmentToItemDetailFragment) object;
      if (arguments.containsKey("text") != that.arguments.containsKey("text")) {
        return false;
      }
      if (getText() != null ? !getText().equals(that.getText()) : that.getText() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getText() != null ? getText().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionTodolistFragmentToItemDetailFragment(actionId=" + getActionId() + "){"
          + "text=" + getText()
          + "}";
    }
  }
}
