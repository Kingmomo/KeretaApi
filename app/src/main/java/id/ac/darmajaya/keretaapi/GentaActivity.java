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

public class GentaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PencarianAdapter word_adapter;
    private List<Semboyan> SemboyanModelList;
    private DatabaseHelper mDBHelper;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.langsir_activity);


        recyclerView=(RecyclerView) findViewById(R.id.rvWord);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        mDBHelper=new DatabaseHelper(getApplicationContext());

        SemboyanModelList=mDBHelper.getdata(getIntent().getStringExtra("DB"));

        word_adapter=new PencarianAdapter();
        word_adapter.setData(SemboyanModelList);
        recyclerView.setAdapter(word_adapter);

    }

}
