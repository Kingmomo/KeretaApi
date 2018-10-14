package id.ac.darmajaya.keretaapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PengertianDetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pengertian_detail);

        TextView judul = (TextView) findViewById(R.id.judul);
        TextView deskripsi= (TextView) findViewById(R.id.deskripsi);

        judul.setText(getIntent().getStringExtra("JUDUL"));
        deskripsi.setText(getIntent().getStringExtra("DESKRIPSI"));
    }

}