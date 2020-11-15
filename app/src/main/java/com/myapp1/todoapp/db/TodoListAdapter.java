package com.myapp1.todoapp.db;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class TodoListAdapter extends RealmBaseAdapter {
    public TodoListAdapter(@Nullable OrderedRealmCollection data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
