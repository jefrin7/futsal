package com.example.bookingfutsal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Declaration EditTexts
    EditText editTextusername;
    EditText editTextPassword;

    //Declaration Button
    Button buttonLogin;
    Button buttonLoginuser;

//    Declaration SqliteHelper
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        sqliteHelper = new SqliteHelper(this);
        initViews();

        buttonLoginuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //mengecek user input sudah benar atau belum
                if (validate()) {

                    String user = editTextusername.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    User currentUser = sqliteHelper.Authenticate(new User(null, null, user, Password));


                        //jika user berhasil login maka munculkan activity user
                       Intent intent=new Intent(LoginActivity.this,utama.class);
                        startActivity(intent);
                        finish();
                }
            }
        });

        editTextusername = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userKey = editTextusername.getText().toString();
                String passwordKey = editTextPassword.getText().toString();

                if (userKey.equals("admin@bookingfutsal.com") && passwordKey.equals("bookingfutsal12345")){

                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, dashboard.class);
                    LoginActivity.this.startActivity(intent);
                    finish();
                }else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username atau Password Anda salah!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }

        });
    }

    public void btnRegister(View v){
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
    }

    public void btnAbout(View v){
        Intent intent = new Intent(LoginActivity.this, tentang.class);
        startActivity(intent);
    }

    private void initViews() {
        editTextusername = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLoginuser = (Button) findViewById(R.id.buttonLoginuser);

    }

    public boolean validate() {
        boolean valid = false;


        String user = editTextusername.getText().toString();
        String Password = editTextPassword.getText().toString();


            Toast.makeText(this, "Masukkan e-mail yang benar", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Tolong isi password yang benar", Toast.LENGTH_LONG).show();

        return valid;
    }
}
