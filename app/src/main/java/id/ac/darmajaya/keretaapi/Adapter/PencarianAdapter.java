package id.ac.darmajaya.keretaapi.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.ac.darmajaya.keretaapi.Model.Semboyan;
import id.ac.darmajaya.keretaapi.PencarianActivity;
import id.ac.darmajaya.keretaapi.PencarianDetailActivity;
import id.ac.darmajaya.keretaapi.R;

public class PencarianAdapter extends RecyclerView.Adapter<PencarianAdapter.ViewHolder> {

    public List<Semboyan> data;

    public PencarianAdapter(){}
    public void setData(List<Semboyan> data){
        this.data=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View wordView=inflater.inflate(R.layout.pencarian_rcv,parent,false);
        ViewHolder viewHolder=new ViewHolder(wordView,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Semboyan Semboyan=data.get(position);
        holder.wordText.setText(Semboyan.getSingkatan());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public TextView wordText;
        public ViewHolder(View itemView, final Context context) {
            super(itemView);
            this.context=context;
            wordText=(TextView) itemView.findViewById(R.id.singkatantv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    Semboyan Semboyan=data.get(position);
                    Intent intent=new Intent(context, PencarianDetailActivity.class);
                    intent.putExtra("ID",Semboyan.getId());
                    intent.putExtra("SINGKATAN",Semboyan.getSingkatan());
                    intent.putExtra("PENJELASAN",Semboyan.getPenjelasan());
                    intent.putExtra("GAMBAR",Semboyan.getGambar());
                    intent.putExtra("MUSIK", Semboyan.getMusik());
                    context.startActivity(intent);
                }
            });
        }
    }
}
