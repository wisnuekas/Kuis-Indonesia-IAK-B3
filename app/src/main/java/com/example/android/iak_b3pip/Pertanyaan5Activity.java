package com.example.android.iak_b3pip;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pertanyaan5Activity extends AppCompatActivity {

    Button next;
    RadioGroup radioGroup;
    RadioButton benar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan5);

        next = (Button) findViewById(R.id.pertanyaan6);
        next.setOnClickListener(new BtnListener());

    }

    protected class BtnListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            radioGroup = (RadioGroup) findViewById(R.id.radio_button_grup);
            benar = (RadioButton) findViewById(R.id.radio_button_ketiga);

            Intent prev = getIntent();

            Data d = (Data) prev.getSerializableExtra("Data");

            if (radioGroup.getCheckedRadioButtonId() == -1)
            {
                // no radio buttons are checked
                AlertDialog alertDialog = new AlertDialog.Builder(
                        Pertanyaan5Activity.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("Jawaban tidak boleh kosong");

                // Setting Dialog Message
                alertDialog.setMessage("Harus ada minimal 1 jawaban untuk lanjut ke pertanyaan berikutnya.");

                // Setting OK Button
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                    }
                });

                // Showing Alert Message
                alertDialog.show();
            }
            else
            {
                // one of the radio buttons is checked
                if(benar.isChecked()){
                    d.incrementSkor();
                }

                Intent next = new Intent(Pertanyaan5Activity.this, Pertanyaan6Activity.class);
                next.putExtra("Data", d);
                startActivity(next);
            }

        }
    }
    @Override
    public void onResume() {
        // After a pause OR at startup
        super.onResume();

        //Refresh value skor
        Intent prev = getIntent();
        Data d = (Data) prev.getSerializableExtra("Data");

        benar = (RadioButton) findViewById(R.id.radio_button_ketiga);

        if(benar.isChecked()){
            if(d.getSkor() > 0){
                d.decrementSkor();
            }
        }
    }
}
