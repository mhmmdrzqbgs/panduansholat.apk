// Generated by view binder compiler. Do not edit!
package com.example.panduansholat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.panduansholat.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemDoaBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView arabic;

  @NonNull
  public final TextView latin;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView terjemahan;

  private ItemDoaBinding(@NonNull LinearLayout rootView, @NonNull TextView arabic,
      @NonNull TextView latin, @NonNull TextView name, @NonNull TextView terjemahan) {
    this.rootView = rootView;
    this.arabic = arabic;
    this.latin = latin;
    this.name = name;
    this.terjemahan = terjemahan;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemDoaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemDoaBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_doa, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemDoaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.arabic;
      TextView arabic = ViewBindings.findChildViewById(rootView, id);
      if (arabic == null) {
        break missingId;
      }

      id = R.id.latin;
      TextView latin = ViewBindings.findChildViewById(rootView, id);
      if (latin == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.terjemahan;
      TextView terjemahan = ViewBindings.findChildViewById(rootView, id);
      if (terjemahan == null) {
        break missingId;
      }

      return new ItemDoaBinding((LinearLayout) rootView, arabic, latin, name, terjemahan);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
