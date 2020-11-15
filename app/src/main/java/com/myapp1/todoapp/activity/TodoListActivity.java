package com.myapp1.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Int4;
import android.view.Menu;
import android.view.MenuItem;

import com.myapp1.todoapp.R;
import com.myapp1.todoapp.etc.SetDialog;

public class TodoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);
    }

    /**
     * Action bar 関連
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_todolist, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SetDialog setDialog = new SetDialog();

        switch (item.getItemId()) {
            case R.id.menu_add:
                Intent intentInput = new Intent(TodoListActivity.this,InputEditActivity.class);
                startActivity(intentInput);
                return true;

            case R.id.menu_delete_all:
                setDialog.createDeleteDialog(TodoListActivity.this,true);
                return true;

            case R.id.menu_filter:
                setDialog.createFilterDialog(TodoListActivity.this);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}