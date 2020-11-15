package com.myapp1.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.myapp1.todoapp.R;
import com.myapp1.todoapp.etc.SetDialog;

public class InputEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_edit);
    }

    /**
     * Action bar 関連
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SetDialog setDialog = new SetDialog();

        switch (item.getItemId()) {
            case R.id.menu_home:
                Intent intentHome = new Intent(InputEditActivity.this,TodoListActivity.class);
                startActivity(intentHome);
                return true;

            case R.id.menu_delete:
                setDialog.createDeleteDialog(InputEditActivity.this,false);
                return true;

            case R.id.menu_save:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}