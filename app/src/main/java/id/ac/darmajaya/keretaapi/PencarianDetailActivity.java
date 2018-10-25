package id.ac.darmajaya.keretaapi;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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

    private ImageView musik;
    private int mstatus = 0;
    private MediaPlayer ring;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pencarian_detail);

        TextView singkatan = (TextView) findViewById(R.id.singkatan);
        TextView penjelasan = (TextView) findViewById(R.id.penjelasan);
        ImageView gambar = (ImageView) findViewById(R.id.gambar);
        musik = (ImageView) findViewById(R.id.musik);
        final String datamusik = getIntent().getStringExtra("MUSIK");




        if (datamusik.equals("") || datamusik == null){
            musik.setVisibility(View.GONE);

        }

        musik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(mstatus == 0) {
                    ring= MediaPlayer.create(getApplicationContext(), Uri.parse("android.resource://"+getPackageName()+"/raw/"+getIntent().getStringExtra("MUSIK")));
                    ring.start();
                    mstatus =1;
                    musik.setImageResource(R.drawable.ic_stop);

                }else{
                    ring.stop();
                    musik.setImageResource(R.drawable.ic_play);
                    mstatus =0;
                }
            }
        });


        singkatan.setText(getIntent().getStringExtra("SINGKATAN"));
        penjelasan.setText(getIntent().getStringExtra("PENJELASAN"));

        Picasso.get()
                .load("file:///android_asset/gambar/"+getIntent().getStringExtra("GAMBAR"))
                .into(gambar);


    }


}