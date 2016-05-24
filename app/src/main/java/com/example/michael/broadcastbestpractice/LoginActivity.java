package com.example.michael.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by michael on 2016/4/15.
 */
public class LoginActivity extends BaseActivity{
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText)findViewById(R.id.account);
        passwordEdit = (EditText)findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        login = (Button)findViewById(R.id.button);
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String account = accountEdit.getText().toString();
               String password = passwordEdit.getText().toString();
               if(account.equals("123")&&password.equals("123")){
                   editor = pref.edit();
                   if(rememberPass.isChecked()){
                       editor.putBoolean("remember_password",true);
                       editor.putString("account",account);
                       editor.putString("password",password);
                   }
                   else{
                       editor.clear();
                   }
                   editor.commit();
                   Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                   startActivity(intent);
                   finish();
               }
               else{
                   Toast.makeText(LoginActivity.this,"用户名或密码输入错误",Toast.LENGTH_SHORT).show();
               }
           }
       });
    }
}
