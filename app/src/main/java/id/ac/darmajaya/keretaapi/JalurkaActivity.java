package id.ac.darmajaya.keretaapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import id.ac.darmajaya.keretaapi.SemboyanJalur.SemboyanSementaraActivity;
import id.ac.darmajaya.keretaapi.SemboyanJalur.SemboyanTetapActivity;

public class JalurkaActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jalurka);


        Button smbsementara = (Button) findViewById(R.id.smbsementara);
        Button smbtetap = (Button) findViewById(R.id.smbtetap);
        Button smbwesel = (Button) findViewById(R.id.smbwesel);

        smbsementara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SemboyanSementaraActivity.class));
            }
        });

        smbtetap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SemboyanTetapActivity.class));
            }
        });

        smbwesel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubLayoutActivity.class);
                intent.putExtra("JUDUL", "Semboyan Terlihat");
                intent.putExtra("DB", "swesel");
                startActivity(intent);
            }
        });

    }

}
