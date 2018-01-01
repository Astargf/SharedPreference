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
import android.widget.EditText;

public class Main0Activity extends AppCompatActivity {

    private AlertDialog.Builder falert;
    private Button fsubmit;
    private EditText fetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String information = prefs.getString("name", "");
        fetext = (EditText) findViewById(R.id.fetext);
        fetext.setText(information);

        //first run
        Boolean frun = getSharedPreferences("Pref", Context.MODE_PRIVATE).getBoolean("firstrun", true);
        if (frun) {
            //first run false
            getSharedPreferences("Pref", Context.MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();
        } else {
            //SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
            //String information = prefs.getString("name", "");
            falert = new AlertDialog.Builder(Main0Activity.this);
            falert.setTitle("Üdvözöllek újra " + information)
                    .setMessage("Folytatod ezen a néven vagy újat akarsz?")
                    .setPositiveButton("Folytatom", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent fomenu = new Intent(Main0Activity.this,MainActivity.class);
                            startActivity(fomenu);
                            finish();
                        }
                    })
                    .setNegativeButton("Új játék", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .setCancelable(false)
                    .create();
            falert.show();
        }

        fsubmit = (Button) findViewById(R.id.fsubmit);

        fsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("name",fetext.getText().toString());
                editor.commit();

                Intent fomenu = new Intent(Main0Activity.this,MainActivity.class);
                startActivity(fomenu);
                finish();
            }
        });
    }
}
