package id.ac.darmajaya.keretaapi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.ac.darmajaya.keretaapi.Model.Pengertian;
import id.ac.darmajaya.keretaapi.PengertianDetailActivity;
import id.ac.darmajaya.keretaapi.R;

public class PengertianAdapter extends RecyclerView.Adapter<PengertianAdapter.ViewHolder> {

    public List<Pengertian> data;

    public PengertianAdapter(){}
    public void setData(List<Pengertian> data){
        this.data=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View wordView=inflater.inflate(R.layout.pengertian_rcv,parent,false);
        ViewHolder viewHolder=new ViewHolder(wordView,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pengertian Pengertian=data.get(position);
        holder.wordText.setText(Pengertian.getPengertian());
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
            wordText=(TextView) itemView.findViewById(R.id.pengertiantv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    Pengertian Pengertian=data.get(position);
                    Intent intent=new Intent(context, PengertianDetailActivity.class);
                    intent.putExtra("JUDUL",Pengertian.getPengertian());
                    intent.putExtra("DESKRIPSI",Pengertian.getDeskripsi());
                    intent.putExtra("MUSIK",Pengertian.getMusik());
                    context.startActivity(intent);

                }
            });
        }
    }
}
