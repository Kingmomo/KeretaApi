package id.ac.darmajaya.keretaapi;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

import id.ac.darmajaya.keretaapi.Adapter.PencarianAdapter;
import id.ac.darmajaya.keretaapi.Database.DatabaseHelper;
import id.ac.darmajaya.keretaapi.Model.Semboyan;

public class PencarianActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PencarianAdapter word_adapter;
    private List<Semboyan> SemboyanModelList;
    private DatabaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pencarian_activity);

        recyclerView=(RecyclerView) findViewById(R.id.rvWord);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        mDBHelper=new DatabaseHelper(PencarianActivity.this);

        SemboyanModelList=mDBHelper.getalldata();

        word_adapter=new PencarianAdapter();
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
*/

/*
        Button cek = (Button) findViewById(R.id.cek);
        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence searchViewQuery = searchView.getQuery();
                cekk = new Intent(PencarianActivity.this, AlgoActivity.class);
                cekk.putExtra("data", searchViewQuery);
                startActivity(cekk);
            }
        });
        */
    }




    public void searchWord(String newText) {
        SemboyanModelList.clear();
        SemboyanModelList = mDBHelper.getListWord(newText);

        word_adapter.setData(SemboyanModelList);
        recyclerView.setAdapter(word_adapter);
    }

}