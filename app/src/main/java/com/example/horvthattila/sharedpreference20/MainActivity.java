package com.example.horvthattila.sharedpreference20;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4;
    private AlertDialog.Builder alert;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adat kiolvasása
        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String information = prefs.getString("name", "");

        textView = (TextView) findViewById(R.id.textview);
        textView.setText(information);

        init();
        onclicklisteners();
    }

    public void init(){
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Biztos kilépsz?")
                .setMessage("Biztosan ki akarsz lépni a programból?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setCancelable(false)
                .create();
    }

    public void onclicklisteners() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(gonext);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gosave = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(gosave);
                finish();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                String information = prefs.getString("name", "");
                Toast.makeText(MainActivity.this, "A neved: " + information,Toast.LENGTH_SHORT).show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.show();
            }
        });
    }
}