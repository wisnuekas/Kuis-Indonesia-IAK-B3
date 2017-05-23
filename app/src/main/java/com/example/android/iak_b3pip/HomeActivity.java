package com.example.android.iak_b3pip;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        EditText nama = (EditText) findViewById(R.id.nama);
        String stringName = nama.getText().toString();

        Data d = new Data(stringName);

        if (nama.getText().toString().trim().length() <= 0){
            AlertDialog alertDialog = new AlertDialog.Builder(
                    HomeActivity.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("Nama tidak boleh kosong");

            // Setting Dialog Message
            alertDialog.setMessage("Silahkan masukan namamu untuk memulai kuis");

            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed
                }
            });

            // Showing Alert Message
            alertDialog.show();
        }else {
            Intent i = new Intent(HomeActivity.this, MainActivity.class);
            i.putExtra("Data", d);
            startActivity(i);
        }


    }
}
