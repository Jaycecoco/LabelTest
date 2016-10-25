package com.huangxiao.labletest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Abbey on 2016/10/24 0024.
 */

public class MyDialog extends Activity implements DialogInterface.OnClickListener  {

    public AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onShowPromptDialog();
    }

    public void onShowPromptDialog(){
        LayoutInflater layoutInflater=LayoutInflater.from(this);
        View view=layoutInflater.inflate(R.layout.add_person_laybel,null);

        builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("添加标签");
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
