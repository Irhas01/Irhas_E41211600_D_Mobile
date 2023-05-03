package com.example.minggu9;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText mViewUser, mViewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mViewUser=findViewById(R.id.et_emailSignin);
        mViewPassword =findViewById(R.id.et_passwordSignin);
        mViewPassword.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                validateSignin();
                return true;
            }
            return false;
        });

        findViewById(R.id.button_signinSignin).setOnClickListener(v -> validateSignin());
        findViewById(R.id.button_signupSignin).setOnClickListener(v -> startActivity(new Intent(getBaseContext(), Register.class)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(getBaseContext(), MainActivity.class));
            finish();
        }
    }


    private void validateSignin(){
        mViewUser.setError(null);
        mViewPassword.setError(null);
        View view = null;
        boolean cancel = false;


        String user = mViewUser.getText().toString();
        String password = mViewPassword.getText().toString();


        if (TextUtils.isEmpty(user)){
            mViewUser.setError("This field is required");
            view = mViewUser;
            cancel = true;
        }else if(!checkUser(user)){
            mViewUser.setError("This Username is not found");
            view = mViewUser;
            cancel = true;
        }


        if (TextUtils.isEmpty(password)){
            mViewPassword.setError("This field is required");
            view = mViewPassword;
            cancel = true;
        }else if (!checkPassword(password)){
            mViewPassword.setError("This password is incorrect");
            view = mViewPassword;
            cancel = true;
        }


        if (cancel) {
            view.requestFocus();
        }
        else {
            signin();
        }
    }


    private void signin(){
        Preferences.setLoggedInUser(getBaseContext(),Preferences.getRegisteredUser(getBaseContext()));
        Preferences.setLoggedInStatus(getBaseContext(),true);
        startActivity(new Intent(getBaseContext(), MainActivity.class));
        finish();
    }

    private boolean checkPassword(String password){
        return password.equals(Preferences.getRegisteredPass(getBaseContext()));
    }


    private boolean checkUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}
