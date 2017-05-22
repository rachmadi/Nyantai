package info.rekayasa.nyantai.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import info.rekayasa.nyantai.R;

public class SignInActivity extends AppCompatActivity {

    Button signInButton, signUpButton;
    EditText emailInput, passwordInput;
    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        emailInput = (EditText) findViewById(R.id.email_edittext);
        passwordInput = (EditText) findViewById(R.id.password_eidttext);
        signUpButton = (Button) findViewById(R.id.signup_button);
        signInButton = (Button) findViewById(R.id.signin_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
                finish();
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                // menampilkan progressbar
                progressBar.setVisibility(View.VISIBLE);

                signIn(email, password);
            }
        });
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                    finish();
                    // sembunyikan progressbar
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(getApplication(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    // sembunyikan progressbar
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
