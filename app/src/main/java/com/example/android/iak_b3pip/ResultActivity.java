package com.example.android.iak_b3pip;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent prev = getIntent();
        Data d = (Data) prev.getSerializableExtra("Data");

        int skor = d.getSkor();
        String nama = "Hai, " + d.getNama() + " skor kamu";

        displayNama(nama);
        displaySkor(skor);
        displayCongrats(skor);

        Button restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(this);
    }

    private void displayCongrats(int skor) {

        TextView congrats = (TextView) findViewById(R.id.congrats);

        if (skor < 6){
            congrats.setText("Wah sepertinya kamu belum beruntung, coba lagi ya !");
        }else {
            congrats.setText("Selamat ya, kamu Indonesia sekali ! :)");
        }
    }

    private void displayNama(String nama){

        TextView namaResult = (TextView) findViewById(R.id.nama_result);

        namaResult.setText(nama);
    }

    private void displaySkor(int skor){


        TextView hasil = (TextView) findViewById(R.id.hasil);

        hasil.setText(String.valueOf(skor));
    }


    @Override
    public void onClick(View v) {

        Intent i = new Intent(ResultActivity.this, HomeActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        // Write your code here
        AlertDialog alertDialog = new AlertDialog.Builder(
                ResultActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Kamu tidak bisa kembali ke kuis sebelumnya");

        // Setting Dialog Message
        alertDialog.setMessage("Silahkan memulai kembali Kuis dengan mengetuk tombol MULAI ULANG");

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
            }
        });

        // Showing Alert Message
        alertDialog.show();

//        super.onBackPressed();
    }
}
