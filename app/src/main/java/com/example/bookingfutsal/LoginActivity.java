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

                    String EMAIL = editTextusername.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    //Authenticate user
                    User currentUser = sqliteHelper.Authenticate(new User(null, null, EMAIL, Password));

                    //Check Authentication is successful or not
                    if (currentUser != null) {

                        //User Logged in Successfully Launch You home screen activity
                        Intent intent = new Intent(LoginActivity.this, dashboard.class);
                        startActivity(intent);
                        finish();

                    } else {

                        //User Logged in Failed
                        Toast.makeText(LoginActivity.this, "Failed to log in , please try againy", Toast.LENGTH_LONG).show();

                    }

                }
            }

        });
    }

    public void btntentang(View view) {
        Intent intent = new Intent(LoginActivity.this, tentang.class);
        startActivity(intent);
    }

    public void btnRegister(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void initViews() {
        editTextusername = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLoginuser = (Button) findViewById(R.id.buttonLogin);

    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Email = editTextusername.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            editTextusername.setError("Please enter valid email!");
        } else {
            valid = true;
            editTextusername.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            editTextPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                editTextPassword.setError(null);
            } else {
                valid = false;
                editTextPassword.setError("Password is to short!");
            }
        }

        return valid;
    }
}