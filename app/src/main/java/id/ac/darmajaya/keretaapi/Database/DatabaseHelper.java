package id.ac.darmajaya.keretaapi.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import id.ac.darmajaya.keretaapi.Model.Pengertian;
import id.ac.darmajaya.keretaapi.Model.Semboyan;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME="keretaapi.sqlite";
    public static final String DBLOCATION="/data/data/id.ac.darmajaya.keretaapi/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;


    public boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("Database", "Copy Success");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public DatabaseHelper(Context context){
        super(context,DBNAME,null,1);
        this.mContext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }
    
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    
    public void openDatabase(){
        String dbPath=mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase!=null && mDatabase.isOpen()){
            return;
        }
        mDatabase=SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);
    }
    
    public void closeDatabase(){
        if(mDatabase !=null){
            mDatabase.close();
        }
    }

    public List<Semboyan> getListWord(String wordSearch){
        Semboyan dictionaryModel=null;
        List<Semboyan> dictionaryModelList=new ArrayList<>();
        openDatabase();
        String[] args={"%"+wordSearch+"%"};

        Cursor cursor=mDatabase.rawQuery("Select * From semboyan Where singkatan Like ? order by singkatan asc",args);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            dictionaryModel=new Semboyan(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5));
            dictionaryModelList.add(dictionaryModel);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return dictionaryModelList;
    }


    public List<Semboyan> getalldata(){
        Semboyan dictionaryModel=null;
        List<Semboyan> dictionaryModelList=new ArrayList<>();
        openDatabase();

        Cursor cursor=mDatabase.rawQuery("Select * From semboyan order by singkatan asc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            dictionaryModel=new Semboyan(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3)
                    , cursor.getString(4), cursor.getString(5));
            dictionaryModelList.add(dictionaryModel);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return dictionaryModelList;
    }




    public List<Semboyan> getdata(String data){
        Semboyan dictionaryModel=null;
        List<Semboyan> dictionaryModelList=new ArrayList<>();
        openDatabase();


        Cursor cursor=mDatabase.rawQuery("Select * From semboyan where kategori = \"" +  data + "\" order by singkatan asc", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            dictionaryModel=new Semboyan(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3)
                    , cursor.getString(4), cursor.getString(5));
            dictionaryModelList.add(dictionaryModel);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return dictionaryModelList;
    }

    public List<Pengertian> getkereta(){
        Pengertian dictionaryModel=null;
        List<Pengertian> dictionaryModelList=new ArrayList<>();
        openDatabase();


        Cursor cursor=mDatabase.rawQuery("Select * From pengertian order by judul asc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            dictionaryModel=new Pengertian(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
            dictionaryModelList.add(dictionaryModel);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return dictionaryModelList;
    }


}
