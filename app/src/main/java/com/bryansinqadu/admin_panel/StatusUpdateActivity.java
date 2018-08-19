package com.bryansinqadu.admin_panel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StatusUpdateActivity extends AppCompatActivity {

    private Button updatestatus;
    private Spinner spinner;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_update);

        updatestatus = (Button) findViewById(R.id.btnUpdate);

        UpdateStatus();
    }

    public void UpdateStatus(){
        updatestatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
