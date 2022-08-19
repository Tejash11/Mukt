package com.example.mukt.signup_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mukt.R;
import com.example.mukt.signup_onboarding.SelectInterest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    TextView login_btn, signup_btn;
    CheckBox checkin_signup;
    EditText userid, pwd;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        login_btn = (TextView) findViewById(R.id.login_btn);
        signup_btn = (TextView) findViewById(R.id.signup_btn);
        checkin_signup = (CheckBox) findViewById(R.id.checkin_signup);
        userid = (EditText) findViewById(R.id.signup_userid);
        pwd = (EditText) findViewById(R.id.signup_pwd);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this, LogIn.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpNewUser(userid.getText().toString(), pwd.getText().toString());

            }
        });








    }

    void SignUpNewUser(String userid, String password)
    {

        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(userid, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent i = new Intent(SignUp.this, SelectInterest.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(i);
                            Toast.makeText(SignUp.this, "Registered Sucessfully",
                                    Toast.LENGTH_SHORT).show();


                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
}