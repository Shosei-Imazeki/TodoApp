package com.myapp1.todoapp.etc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.myapp1.todoapp.R;

import java.util.ArrayList;
import java.util.List;

public class SetDialog {

    /**
     *     フィルター項目から1つを選択するダイアログ
     *     (ラジオボタン)
     */
    public void createFilterDialog(Context context) {
       final String[] filterItem = {
                "すべてのTODO",
                "本日のTODO",
                "3日以内のTODO",
                "未完了のTODO",
                "完了済のTODO"
        };
        int defaultItem = 0; //デフォルトでチェックされているアイテム
        final List<Integer> checkedItems = new ArrayList<>();
        checkedItems.add(defaultItem);
        new AlertDialog.Builder(context)
                .setTitle("TODOを絞り込む")
                .setIcon(R.drawable.ic_action_filter)
                .setSingleChoiceItems(filterItem, defaultItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkedItems.clear();
                        checkedItems.add(which);
                    }
                })
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!checkedItems.isEmpty()) {
                    Log.d("SetDialog#createFilerDialog","" + filterItem[checkedItems.get(0)]);

                    //DBに接続して、条件に沿ったTODOを取得する
                    //TODO:DBにつなげるメソッドを書く　"checkedItems.get(0)"を引数として渡して識別

                }
            }
        })
        .setNegativeButton("Cancel",null)
        .show();
    }

    /**
     * 削除ダイアログを生成
     * title,message,OK/Cancelを配置
     * 全削除か1件削除かで場合分け
     * (TodoListActivity->コンテキストメニュー内の項目、InputEdit->アクションバーメニュー)
     */
    public void createDeleteDialog(Context context, boolean FlgAllOrOne) {
        if(FlgAllOrOne) { //全てのTOODを削除
            new AlertDialog.Builder(context)
                    .setIcon(R.drawable.ic_action_warning)
                    .setTitle("TODO全削除")
                    .setMessage("登録されているTODOを全て削除します。\n" +
                            "よろしいですか。")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // OK button pressed
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();

        } else { //選択された1件だけを削除
            new AlertDialog.Builder(context)
                    .setIcon(R.drawable.ic_action_warning)
                    .setTitle("TODO削除")
                    .setMessage("選択されたTODOを削除します。\n" +
                            "よろしいですか。")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // OK button pressed
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();

        }
    }
}
