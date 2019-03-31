package id.ac.darmajaya.keretaapi;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

import java.io.File;

import id.ac.darmajaya.keretaapi.Database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button pencarian = (Button) findViewById(R.id.pencarian);
        Button jalurka = (Button) findViewById(R.id.jalurka);
        Button keretaapi = (Button) findViewById(R.id.keretaapi);
        Button langsir = (Button) findViewById(R.id.langsir);
        Button genta = (Button) findViewById(R.id.genta);
        Button pengertian = (Button) findViewById(R.id.pengertian);
        Button tentang = (Button) findViewById(R.id.tentang);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.Toolbar);
        setSupportActionBar(myToolbar);

        database();
/*        pencarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PencarianActivity.class));
            }
        });*/

        jalurka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), JalurkaActivity.class));
            }
        });

        keretaapi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), KeretaapiActivity.class));
            }
        });

        langsir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LangsirActivity.class);
                intent.putExtra("JUDUL", "Semboyan Langsir");
                intent.putExtra("DB", "slangsir");
                startActivity(intent);
            }
        });

        genta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GentaActivity.class);
                intent.putExtra("JUDUL", "Semboyan Genta");
                intent.putExtra("DB", "sgenta");
                startActivity(intent);
            }
        });

        pengertian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PengertianActivity.class));

            }
        });

        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TentangAplikasi.class));

            }
        });

    }


    private void database() {
        db = new DatabaseHelper(this);
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);

        if (database.exists()) {
            db.getReadableDatabase();
            db.close();
            if (db.copyDatabase(this)) {
                //Toast.makeText(getApplicationContext(), "Copy success", Toast.LENGTH_LONG).show();
            } else {
                //Toast.makeText(getApplicationContext(), "Copy failed", Toast.LENGTH_LONG).show();
            }
            return;

        }
        else {
            db.getReadableDatabase();
            db.close();
            db.copyDatabase(this);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        // Get the SearchView and set the searchable configuration
        MenuItem mSearch = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) mSearch.getActionView();
        searchView.setQueryHint("Cari Data");
        searchView.setMaxWidth(Integer.MAX_VALUE);



        //searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        ComponentName cn = new ComponentName(this, PencarianActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(cn));

        return true;
    }
}
