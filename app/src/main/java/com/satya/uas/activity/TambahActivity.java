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
        final String NamaLengkap = tNamaLengkap.getText().toString();
        final String NoHp = tNoHp.getText().toString();
        final String Umur = tUmur.getText().toString();
        final String Alamat = tAlamat.getText().toString();
        final String Email = tEmail.getText().toString();

        if ( NamaLengkap.isEmpty() || NoHp.isEmpty() || Umur.isEmpty() || Alamat.isEmpty() || Email.isEmpty()){
            showMessage("Mohon isi semua kolom ");
        }else {
            Biodata arisan = new Biodata(NamaLengkap,NoHp,Umur,Alamat,Email);
            databaseReference.child(Email).child("NamaLengkap").setValue(NamaLengkap.toString());
            databaseReference.child(Email).child("NoHp").setValue(NoHp.toString());
            databaseReference.child(Email).child("Umur").setValue(Umur.toString());
            databaseReference.child(Email).child("Alamat").setValue(Alamat.toString());
            databaseReference.child(Email).child("Email").setValue(Email.toString());

            Toast.makeText(getApplication(),"Success",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        }
    }

    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }
}
