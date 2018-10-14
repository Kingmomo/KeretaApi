package id.ac.darmajaya.keretaapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class KeretaapiActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keretaapi);


        Button terlihat = (Button) findViewById(R.id.terlihat);
        Button suara = (Button) findViewById(R.id.suara);

        terlihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubLayoutActivity.class);
                intent.putExtra("JUDUL", "Semboyan Terlihat");
                intent.putExtra("DB", "sterlihat");
                startActivity(intent);
            }
        });

        suara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubLayoutActivity.class);
                intent.putExtra("JUDUL", "Semboyan Terlihat");
                intent.putExtra("DB", "ssuara");
                startActivity(intent);
            }
        });


    }

}