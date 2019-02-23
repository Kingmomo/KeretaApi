package id.ac.darmajaya.keretaapi.SemboyanJalur;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import id.ac.darmajaya.keretaapi.R;
import id.ac.darmajaya.keretaapi.SubLayoutActivity;

public class SemboyanSementaraActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbynsementara_activity);


        Button isyarat = (Button) findViewById(R.id.isyarat);
        Button tanda = (Button) findViewById(R.id.tanda);

        isyarat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubLayoutActivity.class);
                intent.putExtra("JUDUL", "Semboyan Terlihat");
                intent.putExtra("DB", "ssementaraisyarat");
                startActivity(intent);
            }
        });

        tanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubLayoutActivity.class);
                intent.putExtra("JUDUL", "Semboyan Terlihat");
                intent.putExtra("DB", "ssementaratanda");
                startActivity(intent);
            }
        });

    }

}
