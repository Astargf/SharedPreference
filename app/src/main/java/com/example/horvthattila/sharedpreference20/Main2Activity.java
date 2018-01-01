package com.example.horvthattila.sharedpreference20;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button buttonb;
    private EditText editTextb;

    @Override
    protected void onCreate (final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String information = prefs.getString("name", "");

        editTextb = (EditText) findViewById(R.id.editTextb);
        editTextb.setText(information);

        buttonb = (Button) findViewById(R.id.buttonb);


        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("name",editTextb.getText().toString());
                editor.commit();

                Intent vissza_menube = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(vissza_menube);
                Toast.makeText(Main2Activity.this, "Név mentve", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}