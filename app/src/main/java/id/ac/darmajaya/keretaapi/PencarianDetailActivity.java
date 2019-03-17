package id.ac.darmajaya.keretaapi;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class PencarianDetailActivity extends AppCompatActivity {

    private ImageView musik, musik_penjelasan;
    private int mstatus = 0, mstatus2 = 0;
    private MediaPlayer ring, ring2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pencarian_detail);

        TextView singkatan = (TextView) findViewById(R.id.singkatan);
        TextView penjelasan = (TextView) findViewById(R.id.penjelasan);
        ImageView gambar = (ImageView) findViewById(R.id.gambar);
        musik = (ImageView) findViewById(R.id.musik);
        musik_penjelasan = (ImageView) findViewById(R.id.musik_penjelasan);
        final String datamusik = getIntent().getStringExtra("MUSIK");
        final String datamusik2 = getIntent().getStringExtra("MUSIK2");

        if (datamusik.equals("") || datamusik == null) {
            musik.setVisibility(View.GONE);

        }

        musik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mstatus == 0) {
                    ring = MediaPlayer.create(getApplicationContext(), Uri.parse("android.resource://" + getPackageName() + "/raw/" + getIntent().getStringExtra("MUSIK")));
                    ring.start();
                    mstatus = 1;
                    musik.setImageResource(R.drawable.ic_stop);

                } else {
                    ring.stop();
                    musik.setImageResource(R.drawable.ic_play);
                    mstatus = 0;
                }
            }
        });

        //musik penjelasan
        if (datamusik2.equals("") || datamusik2 == null) {
            musik_penjelasan.setVisibility(View.GONE);

        }

        musik_penjelasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mstatus2 == 0) {
                    ring2 = MediaPlayer.create(getApplicationContext(), Uri.parse("android.resource://" + getPackageName() + "/raw/" + getIntent().getStringExtra("MUSIK2")));
                    ring2.start();
                    mstatus2 = 1;
                    musik_penjelasan.setImageResource(R.drawable.ic_stop);

                } else {
                    ring2.stop();
                    mstatus2 = 0;
                    musik_penjelasan.setImageResource(R.drawable.ic_play);
                }
            }
        });


        singkatan.setText(getIntent().getStringExtra("SINGKATAN"));
        penjelasan.setText(getIntent().getStringExtra("PENJELASAN"));

        Picasso.get()
                .load("file:///android_asset/gambar/" + getIntent().getStringExtra("GAMBAR"))
                .into(gambar);


    }

    @Override
    protected void onStop() {
        super.onStop();
//        if (!datamusik.equals("") || datamusik != null & mstatus2 == 0 ) {
//            ring2.stop();
//            mstatus2 = 0;
//            musik_penjelasan.setImageResource(R.drawable.ic_play);
//        }
    }
}