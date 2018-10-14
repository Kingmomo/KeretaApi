package id.ac.darmajaya.keretaapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.ac.darmajaya.keretaapi.Adapter.PencarianAdapter;
import id.ac.darmajaya.keretaapi.Database.DatabaseHelper;
import id.ac.darmajaya.keretaapi.Model.Semboyan;


public class PencarianDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pencarian_detail);

        TextView singkatan = (TextView) findViewById(R.id.singkatan);
        TextView penjelasan = (TextView) findViewById(R.id.penjelasan);
        ImageView gambar = (ImageView) findViewById(R.id.gambar);
        ImageView musik = (ImageView) findViewById(R.id.musik);
        String datamusik = getIntent().getStringExtra("MUSIK");

        if (datamusik.equals("") || datamusik == null){
            musik.setVisibility(View.GONE);

        }
        else
        {

        }


        singkatan.setText(getIntent().getStringExtra("SINGKATAN"));
        penjelasan.setText(getIntent().getStringExtra("PENJELASAN"));

        Picasso.get()
                .load("file:///android_asset/gambar/"+getIntent().getStringExtra("GAMBAR"))
                .into(gambar);


    }
}