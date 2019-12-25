package com.satya.uas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.satya.uas.Model.Biodata;
import com.satya.uas.R;

import java.util.ArrayList;

public class ListBiodata extends AppCompatActivity {

    DatabaseReference databaseReference;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> bioList;
    TextView txtBio;
    Biodata biodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_biodata);
//        txtBio = findViewById(R.id.binfo);
        databaseReference = FirebaseDatabase.getInstance().getReference("Biodata");
        listView = findViewById(R.id.listBio);
        bioList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.biodata_info,R.id.binfo,bioList);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    biodata = postSnapshot.getValue(Biodata.class);
                    bioList.add(biodata.getNamaLengkap());
                }
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                addArisan();
//                Intent intent = new Intent(ListBiodata.this, DetailBio.class);
////                addArisan();
//                intent.putExtra("namaLengkap", listView.getItemAtPosition(i).toString());
//                startActivity(intent);
//            }
//        });

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), TambahActivity.class));
            }
        });
    }
}
