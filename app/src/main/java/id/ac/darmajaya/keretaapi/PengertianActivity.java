package id.ac.darmajaya.keretaapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import id.ac.darmajaya.keretaapi.Adapter.PengertianAdapter;
import id.ac.darmajaya.keretaapi.Database.DatabaseHelper;
import id.ac.darmajaya.keretaapi.Model.Pengertian;

public class PengertianActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PengertianAdapter word_adapter;
    private List<Pengertian> PengertianModelList;
    private DatabaseHelper mDBHelper;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pengertian_activity);


        recyclerView = (RecyclerView) findViewById(R.id.rvWord);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        mDBHelper = new DatabaseHelper(getApplicationContext());

        PengertianModelList = mDBHelper.getkereta();

        word_adapter = new PengertianAdapter();
        word_adapter.setData(PengertianModelList);
        recyclerView.setAdapter(word_adapter);


    }

}
