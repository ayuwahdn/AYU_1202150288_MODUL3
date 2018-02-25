package com.example.android.ayu_1202150288_modul3;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    private EditText mUname;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUname = (EditText) findViewById(R.id.uname);
        mPassword = (EditText) findViewById(R.id.pass);
    }

    public void Login(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        //inisialisai parse ke string
        String username = mUname.getText().toString();
        String password = mPassword.getText().toString();
        if ((username.equals("EAD")) || (password.equals("MOBILE")) ) {
            Toast toast=Toast.makeText(this, "Anda Berhasil Login", Toast.LENGTH_SHORT);
            toast.show();
            startActivity(intent);

        } else {
            //kalo ga sesuai uname sama pass nya nanti keluar toast gagal
            Toast toast = Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT);
            toast.show();}
    }
}

