package com.satya.uas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.satya.uas.R;

public class DetailBio extends AppCompatActivity {

    DatabaseReference databaseReference;

    TextView tNamaLengkap,tNohp,tUmur,tAlamat,tEmail;
    private String bioList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bio);

        tNamaLengkap = findViewById(R.id.txt_namaLengkap);
        tNohp = findViewById(R.id.txt_noHp);
        tUmur = findViewById(R.id.txt_umur);
        tAlamat = findViewById(R.id.txt_alamat_data);
        tEmail = findViewById(R.id.txt_emailData);

        databaseReference = FirebaseDatabase.getInstance().getReference("Biodata");
        bioList = getIntent().getExtras().getString("namaLengkap");
        redData();

    }

    private void redData() {
        Query findByQuery = databaseReference.orderByKey().equalTo(bioList);
        findByQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot getSnapshot : dataSnapshot.getChildren()){
                    tNamaLengkap.setText(getSnapshot.child("namaLengkap").getValue().toString());
                    tNohp.setText(getSnapshot.child("noHp").getValue().toString());
                    tUmur.setText(getSnapshot.child("umur").getValue().toString());
                    tAlamat.setText(getSnapshot.child("alamat").getValue().toString());
                    tEmail.setText(getSnapshot.child("email").getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
