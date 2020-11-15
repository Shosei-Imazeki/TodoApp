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
        Intent intent;

        switch (item.getItemId()) {
            case R.id.menu_home:
                setDialog.createBackConfirmDialog(InputEditActivity.this);
                return true;

            case R.id.menu_delete:
                setDialog.createDeleteDialog(InputEditActivity.this,false);
                return true;

            case R.id.menu_save:
                setDialog.createSaveDialog(InputEditActivity.this);
                //todo:登録できたことを確認するログを出す
                //リスト画面に戻す
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}