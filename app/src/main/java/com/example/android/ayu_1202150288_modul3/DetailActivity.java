package com.example.android.ayu_1202150288_modul3;

/**
 * Created by Annisa Ayu Wahdini on 2/25/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private ImageView WaterView; //membuat inisialisasi variabel
    private int level = 0; //inisialisasi nilai level = 0
    TextView capacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WaterView = (ImageView) findViewById(R.id.WaterView);
        capacity = (TextView) findViewById(R.id.capacity);
        //panggil method capacity
        capacity();

    }
    public void capacity(){
        //buat nampilin level
        switch (level){
            case 0: capacity.setText("2L");
            break;
            case 1: capacity.setText("3L");
            break;
            case 2: capacity.setText("5L");
            break;
            case 3: capacity.setText("6L");
            break;
            case 4: capacity.setText("8L");
            break;
            case 5: capacity.setText("Full");
            break;

        }
    }
    public void LevelUp(View view) {
        //jika level kurang dari 5
        if (level < 5) {
            //level naik
            level++;
            //ambil image dengan sesuai level
            WaterView.setImageLevel(level);
        } else {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Air Sudah Full", Toast.LENGTH_SHORT); // nampilin toast jika air sudah penuh
            toast.show();
        }
        capacity();
    }

    public void LevelDown(View view) {
        if (level > 0) {
            level--;
            WaterView.setImageLevel(level);
        } else{
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Air Sedikit", Toast.LENGTH_SHORT); //nampilin toast jika level sudah terendah
            toast.show();
        }
        capacity();
    }
}
