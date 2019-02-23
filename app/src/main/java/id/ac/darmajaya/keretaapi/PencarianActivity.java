package id.ac.darmajaya.keretaapi;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import id.ac.darmajaya.keretaapi.Adapter.PencarianAdapter;
import id.ac.darmajaya.keretaapi.Algoritma.BruteForce;
import id.ac.darmajaya.keretaapi.Database.DatabaseHelper;
import id.ac.darmajaya.keretaapi.Model.Algo;
import id.ac.darmajaya.keretaapi.Model.Semboyan;

public class PencarianActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PencarianAdapter word_adapter;
    private List<Semboyan> SemboyanModelList;
    private List<Semboyan> hasilago;
    private DatabaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pencarian_activity);

        recyclerView = (RecyclerView) findViewById(R.id.rvWord);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        mDBHelper = new DatabaseHelper(PencarianActivity.this);

        SemboyanModelList = mDBHelper.getalldata();

        word_adapter = new PencarianAdapter();
        word_adapter.setData(SemboyanModelList);
        recyclerView.setAdapter(word_adapter);


        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            searchWord(query);
        }
/*
        final SearchView searchView=(SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {
                cekk = new Intent(PencarianActivity.this, AlgoActivity.class);
                cekk.putExtra("data", newText);
                startActivity(cekk);
                searchWord(newText);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchWord(newText);
                return false;
            }
        });

        Button cek = (Button) findViewById(R.id.cek);
        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence searchViewQuery = searchView.getQuery();
                cekk = new Intent(PencarianActivity.this, AlgoActivity.class);
                cekk.putExtra("data", searchViewQuery);
                startActivity(cekk);
            }
        });*/
    }


    public void searchWord(String newText) {
        SemboyanModelList.clear();
        SemboyanModelList = mDBHelper.getListWord(newText);

        word_adapter.setData(SemboyanModelList);
        recyclerView.setAdapter(word_adapter);
    }

    public void searchalgo(String katapencarian) {
        SemboyanModelList.clear();
        SemboyanModelList = mDBHelper.getalldata();

        BruteForce obj = new BruteForce();
        for (Semboyan p : SemboyanModelList) {
            String text = p.getSingkatan().toUpperCase();
            int position = obj.BruteForce(text, katapencarian);
            int endindex = position;

            if (position == -1) {
                System.out.println("Pattern tidak sama dengan text");
            } else {
                    /*
                    Algo data = new Algo();
                    data.setSingkatan(text);
                    data.setPosisi(position + 1);
                    data.setEndpos(endindex + newText.length());
*/
                //System.out.println(text);
                //System.out.println("======================");
                // System.out.println("Found at position:" + (position + 1));
                // System.out.println("End at the position:" + (endindex + tobematched.length()));
                int a = position + 1;
                int b = endindex + katapencarian.length();

                String mulaiposisi = String.valueOf("Posisi Awal " + a);
                String akhirposisi = String.valueOf("Posisi Akhir " + b);
                String panjanghuruf = String.valueOf("Panjang Huruf " + text.length());
                System.out.print(text);
                Algo movie = new Algo(text, panjanghuruf, mulaiposisi, akhirposisi);

            }
        }
    }

}