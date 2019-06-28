package com.example.bookingfutsal;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    //Declaration EditTexts
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;

    //Declaration Button
    Button buttonRegister;
    Button resetUsername;
    Button resetEmail;
    Button resetPassword;

    //Declaration SqliteHelper
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqliteHelper = new SqliteHelper(this);
        initTextViewLogin();
        initViews();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String UserName = editTextUserName.getText().toString();
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    //mengecek di database apakah ada user yang menggunakan email ini
                    if (!sqliteHelper.isEmailExists(Email)) {

                        //jika email tidak ada maka tambahkan user ke database
                        sqliteHelper.addUser(new User(null, UserName, Email, Password));
                        Toast.makeText(RegisterActivity.this, "User created succesfully", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Toast.LENGTH_LONG);
                    }else {

                        //Jika email telah digunakan oleh user lain maka tampilkan peringatan
                        Toast.makeText(RegisterActivity.this, "User already exists with same email", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        resetUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearUsername();
            }
        });

        resetEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearEmail();
            }
        });

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearPassword();
            }
        });
    }

    private void clearUsername(){
        editTextUserName.getText().clear();
    }

    private void clearEmail(){
        editTextEmail.getText().clear();
    }

    private void clearPassword(){
        editTextPassword.getText().clear();
    }

    //membuat onclick listener pada textview
    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        resetUsername = (Button) findViewById(R.id.resetUsername);
        resetEmail = (Button) findViewById(R.id.resetEmail);
        resetPassword = (Button) findViewById(R.id.resetPassword);

    }

    //method untuk melakukan validasi
    public boolean validate() {
        boolean valid = false;

        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        if (UserName.isEmpty()) {
            valid = false;
            Toast.makeText(this, "masukkan username",Toast.LENGTH_LONG).show();
        }


        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            Toast.makeText(this, "Masukkan e-mail yang benar",Toast.LENGTH_LONG).show();
        } else {
            valid = true;
        }

        if (Password.isEmpty()) {
            valid = false;
            Toast.makeText(this, "Tolong isi password yang benar",Toast.LENGTH_LONG).show();
        }
        return valid;
    }
}
