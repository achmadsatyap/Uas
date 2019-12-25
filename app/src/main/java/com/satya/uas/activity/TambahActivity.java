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
import com.satya.uas.MainActivity;
import com.satya.uas.Model.Biodata;
import com.satya.uas.R;

public class TambahActivity extends AppCompatActivity {

    EditText tNamaLengkap, tNoHp, tUmur, tAlamat, tEmail;
    Button btnSend;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        tNamaLengkap = findViewById(R.id.edit_namaLengkap);
        tNoHp = findViewById(R.id.edt_noHp);
        tUmur = findViewById(R.id.edt_umur);
        tAlamat = findViewById(R.id.edt_alamat_data);
        tEmail = findViewById(R.id.edt_emailData);
        btnSend = findViewById(R.id.btn_send);

        databaseReference = FirebaseDatabase.getInstance().getReference("Biodata");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBiodata();
            }
        });

    }

    private void addBiodata() {
        final String namaLengkap = tNamaLengkap.getText().toString();
        final String noHp = tNoHp.getText().toString();
        final String umur = tUmur.getText().toString();
        final String alamat = tAlamat.getText().toString();
        final String email = tEmail.getText().toString();

        if ( namaLengkap.isEmpty() || noHp.isEmpty() || umur.isEmpty() || alamat.isEmpty() || email.isEmpty()){
            showMessage("Mohon isi semua kolom ");
        }else {
            Biodata biodata = new Biodata(namaLengkap,noHp,umur,alamat,email);
            databaseReference.child(namaLengkap).child("namaLengkap").setValue(namaLengkap.toString());
            databaseReference.child(namaLengkap).child("noHp").setValue(noHp.toString());
            databaseReference.child(namaLengkap).child("umur").setValue(umur.toString());
            databaseReference.child(namaLengkap).child("alamat").setValue(alamat.toString());
            databaseReference.child(namaLengkap).child("email").setValue(email.toString());

            Toast.makeText(getApplication(),"Success",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        }
    }

    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }
}
