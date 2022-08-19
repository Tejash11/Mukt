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

import com.example.mukt.MainActivity;
import com.example.mukt.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

    TextView login_btn, signup_btn;
    CheckBox checkin_signup;

    EditText userid, pwd;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        login_btn = (TextView) findViewById(R.id.login_btn);
        signup_btn = (TextView) findViewById(R.id.signup_btn);
        checkin_signup = (CheckBox) findViewById(R.id.checkin_login);

        userid = (EditText) findViewById(R.id.login_userid);
        pwd = (EditText) findViewById(R.id.login_pwd);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogIn.this, SignUp.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogInUser(userid.getText().toString(), pwd.getText().toString());

            }
        });




    }


    void LogInUser(String userid, String password)
    {

        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(userid, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(LogIn.this, MainActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LogIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });




    }




}