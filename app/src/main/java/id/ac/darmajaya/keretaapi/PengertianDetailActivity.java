package id.ac.darmajaya.keretaapi;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class PengertianDetailActivity extends AppCompatActivity {
    private MediaPlayer ring;
    private int mstatus = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pengertian_detail);

        TextView judul = (TextView) findViewById(R.id.judul);
        TextView deskripsi = (TextView) findViewById(R.id.deskripsi);
        final String datamusik = getIntent().getStringExtra("MUSIK");
//        final ImageView musik = (ImageView) findViewById(R.id.musik_penjelasan);


        MobileAds.initialize(this, "ca-app-pub-2581554412013428~5274222570");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);


        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        judul.setText(getIntent().getStringExtra("JUDUL"));
        deskripsi.setText(getIntent().getStringExtra("DESKRIPSI"));

       /* if (datamusik.equals("") || datamusik == null) {
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
        });*/
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
/*        if (ring != null) {
            ring.stop();
            ring.release();
            ring = null;
        }*/
    }
}