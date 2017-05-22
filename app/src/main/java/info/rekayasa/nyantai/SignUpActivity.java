package info.rekayasa.nyantai;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    Button signInButton, signUpButton;
    EditText emailInput, passwordInput, displayNameInput;
    ProgressBar progressBar;

    FirebaseAuth mAuth;
    FirebaseDatabase mDatabase;
    DatabaseReference mRootRef, mUserRef;

    String TAG = "SignUpAction";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mRootRef = mDatabase.getReference();
        mUserRef = mRootRef.child("users");

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        emailInput = (EditText) findViewById(R.id.email_edittext);
        passwordInput = (EditText) findViewById(R.id.password_eidttext);
        displayNameInput = (EditText) findViewById(R.id.display_name_edittext);

        signInButton = (Button) findViewById(R.id.signin_button);
        signUpButton = (Button) findViewById(R.id.signup_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                String displayName = displayNameInput.getText().toString();

                progressBar.setVisibility(View.VISIBLE);
                createUser (email, password, displayName);
            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                finish();
            }
        });
    }

    private void createUser(final String email, final String password, final String displayName) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    writeUser (email, displayName);
                } else {
                    Log.d(TAG, task.getException().getMessage());
                }
            }
        });
    }

    private void writeUser(String email, String displayName) {
        User user = new User(email, displayName);
        // mUserRef.child("userId").setValue(email, displayName);
        mUserRef.child(mAuth.getCurrentUser().getUid()).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    finish();
                } else {
                    Log.d(TAG, task.getException().getMessage());
                }
            }
        });
    }
}
