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

    private MediaPlayer ring, ring2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pencarian_detail);

        TextView singkatan = (TextView) findViewById(R.id.singkatan);
        TextView penjelasan = (TextView) findViewById(R.id.penjelasan);
        final ImageView gambar = (ImageView) findViewById(R.id.gambar);
        final ImageView musik = (ImageView) findViewById(R.id.musik);
        final ImageView musik_penjelasan = (ImageView) findViewById(R.id.musik_penjelasan);
        final String datamusik = getIntent().getStringExtra("MUSIK");
        final String datamusik2 = getIntent().getStringExtra("MUSIK2");

        if (datamusik.equals("") || datamusik == null) {
            musik.setVisibility(View.GONE);

        }

        musik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mstatus = 0;

                if (mstatus == 0) {
                    ring = MediaPlayer.create(getApplicationContext(), Uri.parse("android.resource://" + getPackageName() + "/raw/" + getIntent().getStringExtra("MUSIK")));
                    ring.start();
                    musik.setImageResource(R.drawable.ic_stop);
                    if (ring2 != null) {
                        ring2.stop();
                        ring2.release();
                        ring2 = null;
                        musik_penjelasan.setImageResource(R.drawable.ic_play);
                    }

                } else {
                    ring.stop();
                    musik.setImageResource(R.drawable.ic_play);
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
                int mstatus2 = 0;
                if (mstatus2 == 0) {
                    ring2 = MediaPlayer.create(getApplicationContext(), Uri.parse("android.resource://" + getPackageName() + "/raw/" + getIntent().getStringExtra("MUSIK2")));
                    ring2.start();
                    musik_penjelasan.setImageResource(R.drawable.ic_stop);
                    if (ring != null) {
                        ring.stop();
                        ring.release();
                        ring = null;
                        musik.setImageResource(R.drawable.ic_play);
                    }

                } else {
                    ring2.stop();
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
    public void onBackPressed() {
        super.onBackPressed();
        if (ring != null) {
            ring.stop();
            ring.release();
            ring = null;
        }
        if (ring2 != null) {
            ring2.stop();
            ring2.release();
            ring2 = null;
        }

    }
}