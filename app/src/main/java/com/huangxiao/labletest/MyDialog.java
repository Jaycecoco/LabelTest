package com.huangxiao.labletest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Abbey on 2016/10/24 0024.
 */

public class MyDialog extends Activity implements DialogInterface.OnClickListener {
    public void onShowPromptDialog(View v){
        LayoutInflater layoutInflater=LayoutInflater.from(this);
        View view=layoutInflater.inflate(R.layout.prompt_view,null);

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setPositiveButton("确定",this);
        builder.setNegativeButton("取消",this);
        builder.create().show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface,int which){
        if (which== Dialog.BUTTON_POSITIVE){
            AlertDialog alertDialog=(AlertDialog)dialogInterface;
            EditText text=(EditText)alertDialog.findViewById(R.id.editText_prompt);
            String content=text.getText().toString().trim();
            //传递信息
            Intent intent=new Intent(this,MainActivity.class);
            intent.putExtra("label",content);
            startActivity(intent);
        }
    }
}
