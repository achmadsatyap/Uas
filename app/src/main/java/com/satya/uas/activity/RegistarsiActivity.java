package com.satya.uas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.satya.uas.Model.Security;
import com.satya.uas.Model.User;
import com.satya.uas.R;

public class RegistarsiActivity extends AppCompatActivity {

    EditText tUsername, tName, tPassword, tAlamat, tEmail;
    Button btnRegis;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registarsi);

        tUsername = findViewById(R.id.edit_username);
        tName = findViewById(R.id.edt_name);
        tPassword = findViewById(R.id.edt_password);
        tAlamat = findViewById(R.id.edt_alamat);
        tEmail = findViewById(R.id.edt_email);
        btnRegis = findViewById(R.id.btn_req);

        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    private void addUser() {
        final String username = tUsername.getText().toString();
        final String nama = tName.getText().toString();
        final String password = tPassword.getText().toString();
        final String alamat = tAlamat.getText().toString();
        final String email = tEmail.getText().toString();

        if (username.isEmpty() || nama.isEmpty() || password.isEmpty() || alamat.isEmpty() || email.isEmpty()){
            showMessage("Mohon isi semua kolom ");
        }else {
            User user= new User(username,nama,password,email,alamat);
            databaseReference.child(username).child("username").setValue(username.toString());
            databaseReference.child(username).child("nama").setValue(nama.toString());
            databaseReference.child(username).child("email").setValue(email.toString());
            databaseReference.child(username).child("alamat").setValue(alamat.toString());
            try {
                databaseReference.child(username).child("password").setValue(Security.encrypt(password));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplication(),"Success",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplication(),LoginActivity.class);
            startActivity(intent);
        }
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}

