package com.bryansinqadu.admin_panel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Toolbar toolbar;
    private EditText name, phone,gender, email, password;
    String Name, Phone,Gender, Email, Password;
    FirebaseAuth mAuth;
    DatabaseReference mdatabase;
    ProgressDialog mDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        name = (EditText)findViewById(R.id.etName);
        phone = (EditText)findViewById(R.id.etPhone);
        gender = (EditText) findViewById(R.id.etGender);
        email = (EditText)findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPassword);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("AdminUsers");

    }

    public void btnRegister(View view) {
        UserRegister();
    }



    private void UserRegister() {
        Name = name.getText().toString().trim();
        Phone = phone.getText().toString().trim();
        Gender = gender.getText().toString().trim();
        Email = email.getText().toString().trim();
        Password = password.getText().toString().trim();


        if (TextUtils.isEmpty(Name)){
            Toast.makeText(RegisterActivity.this, "Enter FullName..", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(Email)){
            Toast.makeText(RegisterActivity.this, "Enter Email..", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(Gender)){
            Toast.makeText(RegisterActivity.this, "Enter Gender..", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(Password)){
            Toast.makeText(RegisterActivity.this, "Enter Password..", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(Phone)){
            Toast.makeText(RegisterActivity.this, "Enter Phone..", Toast.LENGTH_SHORT).show();
            return;
        }else if (Password.length()<6){
            Toast.makeText(RegisterActivity.this,"Password must be greater then 6 digit",Toast.LENGTH_SHORT).show();
            return;
        }
        mDialog.setMessage("Creating User please wait...");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //sendEmailVerification();
                    mDialog.dismiss();
                    OnAuth(task.getResult().getUser());
                    mAuth.signOut();
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    Toast.makeText(RegisterActivity.this,"Successfully registered..you can log in",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterActivity.this,"error on creating user",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendEmailVerification() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this,"Check your Email for verification",Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                    }else{
                        Toast.makeText(RegisterActivity.this,"Email was not sent successfully..",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void OnAuth(FirebaseUser user) {
        createAnewUser(user.getUid());
    }

    private void createAnewUser(String uid) {
        AdminUser user = BuildNewUser();
        mdatabase.child(uid).setValue(user);
    }


    private AdminUser BuildNewUser(){
        return new AdminUser(
                getName(),
                getPhone(),
                getGender(),
                getEmail(),
                getPassword(),
                new Date().getTime()
        );
    }

    public String getName() {
        return Name;
    }
    public String getPhone(){
        return Phone;
    }
    public String getGender(){
        return Gender;
    }
    public String getEmail() {
        return Email;
    }
    public String getPassword(){
        return Password;
    }



}
















        /*   name = (EditText) findViewById(R.id.etName);
        studentid = (EditText) findViewById(R.id.etStudentID);
        pin = (EditText) findViewById(R.id.etPin);
        course = (EditText) findViewById(R.id.etCourse);
        level = (EditText) findViewById(R.id.etLevel);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("Student");
        userProfile = new UserProfile();

    }

    public void btnRegister(View view) {
        userProfile.setName(name.getText().toString());
        userProfile.setStudentID(studentid.getText().toString());
        userProfile.setPin(pin.getText().toString());
        userProfile.setCourse(course.getText().toString());
        userProfile.setLevel(level.getText().toString());

        ref.child(userProfile.getStudentID()).setValue(userProfile).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this,"Student created successfully",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                }else {
                    Toast.makeText(SignUpActivity.this,"Student not registered",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}*/
