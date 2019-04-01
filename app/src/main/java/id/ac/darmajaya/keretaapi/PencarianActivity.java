package id.ac.darmajaya.keretaapi;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdView;

import java.util.List;

import id.ac.darmajaya.keretaapi.Adapter.PencarianAdapter;
import id.ac.darmajaya.keretaapi.Database.DatabaseHelper;
import id.ac.darmajaya.keretaapi.Model.Semboyan;

public class PencarianActivity extends AppCompatActivity {
    private List<Semboyan> SemboyanModelList;
    private DatabaseHelper mDBHelper;
    private PencarianAdapter word_adapter;
    private RecyclerView recyclerView;

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

    }


    public void searchWord(String newText) {
        SemboyanModelList.clear();
        SemboyanModelList = mDBHelper.getListWord(newText);

        word_adapter.setData(SemboyanModelList);
        recyclerView.setAdapter(word_adapter);
    }

}