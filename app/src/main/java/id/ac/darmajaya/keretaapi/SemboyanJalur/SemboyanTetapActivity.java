package id.ac.darmajaya.keretaapi.SemboyanJalur;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import id.ac.darmajaya.keretaapi.R;
import id.ac.darmajaya.keretaapi.SubLayoutActivity;

public class SemboyanTetapActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbytetap_activity);


        Button sinyal = (Button) findViewById(R.id.sinyal);
        Button tandatetap = (Button) findViewById(R.id.tandatatap);
        Button marka = (Button) findViewById(R.id.marka);

        sinyal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubLayoutActivity.class);
                intent.putExtra("JUDUL", "Semboyan Terlihat");
                intent.putExtra("DB", "stetapsinyal");
                startActivity(intent);
            }
        });

        tandatetap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubLayoutActivity.class);
                intent.putExtra("JUDUL", "Semboyan Terlihat");
                intent.putExtra("DB", "stetaptanda");
                startActivity(intent);
            }
        });

        marka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubLayoutActivity.class);
                intent.putExtra("JUDUL", "Semboyan Terlihat");
                intent.putExtra("DB", "stetapmarka");
                startActivity(intent);
            }
        });

    }

}