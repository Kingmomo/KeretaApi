package id.ac.darmajaya.keretaapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import id.ac.darmajaya.keretaapi.Adapter.PencarianAdapter;
import id.ac.darmajaya.keretaapi.Database.DatabaseHelper;
import id.ac.darmajaya.keretaapi.Model.Semboyan;

public class SubLayoutActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sublayout_activity);

        RecyclerView recyclerView;
        PencarianAdapter word_adapter;
        List<Semboyan> SemboyanModelList;
        DatabaseHelper mDBHelper;

        recyclerView = (RecyclerView) findViewById(R.id.rvWord);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        mDBHelper = new DatabaseHelper(getApplicationContext());

        SemboyanModelList = mDBHelper.getdata(getIntent().getStringExtra("DB"));

        word_adapter = new PencarianAdapter();
        word_adapter.setData(SemboyanModelList);
        recyclerView.setAdapter(word_adapter);


    }
}