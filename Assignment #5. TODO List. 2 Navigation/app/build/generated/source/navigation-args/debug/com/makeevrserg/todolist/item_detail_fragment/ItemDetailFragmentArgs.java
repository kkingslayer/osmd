package com.makeevrserg.todolist.item_detail_fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ItemDetailFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ItemDetailFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ItemDetailFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ItemDetailFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ItemDetailFragmentArgs __result = new ItemDetailFragmentArgs();
    bundle.setClassLoader(ItemDetailFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("text")) {
      String text;
      text = bundle.getString("text");
      if (text == null) {
        throw new IllegalArgumentException("Argument \"text\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("text", text);
    } else {
      throw new IllegalArgumentException("Required argument \"text\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getText() {
    return (String) arguments.get("text");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("text")) {
      String text = (String) arguments.get("text");
      __result.putString("text", text);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ItemDetailFragmentArgs that = (ItemDetailFragmentArgs) object;
    if (arguments.containsKey("text") != that.arguments.containsKey("text")) {
      return false;
    }
    if (getText() != null ? !getText().equals(that.getText()) : that.getText() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getText() != null ? getText().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ItemDetailFragmentArgs{"
        + "text=" + getText()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(ItemDetailFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String text) {
      if (text == null) {
        throw new IllegalArgumentException("Argument \"text\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("text", text);
    }

    @NonNull
    public ItemDetailFragmentArgs build() {
      ItemDetailFragmentArgs result = new ItemDetailFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setText(@NonNull String text) {
      if (text == null) {
        throw new IllegalArgumentException("Argument \"text\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("text", text);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getText() {
      return (String) arguments.get("text");
    }
  }
}
