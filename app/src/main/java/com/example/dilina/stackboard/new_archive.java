package com.example.dilina.stackboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class new_archive extends Activity {

    EditText name,author;
    Button add;

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_archive);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();


        name = (EditText) findViewById(R.id.archiveName);
        author = (EditText) findViewById(R.id.archiveAuthor);
        add = (Button) findViewById(R.id.btnAdd);
        final String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("archives");
                String archiveId = mDatabase.push().getKey();
                archive arc = new archive(archiveId,name.getText().toString(),author.getText().toString(),timeStamp);
                mDatabase.child(archiveId).setValue(arc);


            }
        });
    }
}
