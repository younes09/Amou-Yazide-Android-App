package dz.newtechsoft.infotech.yazid_10;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infotech.yazid_10.R;

import java.util.List;

/**
 * Created by younes on 20/07/2018.
 */

public class AdapterTimeLine extends RecyclerView.Adapter<AdapterTimeLine.myViewHolder>{
    Context mContext;
    List<ItemTimeLine> mData;

    public AdapterTimeLine(Context mContext, List<ItemTimeLine> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.event,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder,final int position) {
        holder.d.setText(mData.get(position).getD());
        holder.m.setText(mData.get(position).getM());
        holder.y.setText(mData.get(position).getY());
        holder.t.setText(mData.get(position).getTime());
        holder.discription.setText(mData.get(position).getDescription());
        holder.discription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mData.get(position).getUrl()!=null){
                    Intent intent = new Intent(mContext,ActivityVideoWatch.class);
                    intent.putExtra("VIDEO_ID",mData.get(position).getUrl());
                    intent.putExtra("Categorie", "حفلات");
                    mContext.startActivity(intent);
                    Toast.makeText(mContext, "حفلات", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(mContext, "لايوجد هناك فيدو للحفل", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends  RecyclerView.ViewHolder {

        TextView d,m,y,t;
        TextView discription;

        public myViewHolder(View itemView){
            super(itemView);
            d = itemView.findViewById(R.id.did);
            m = itemView.findViewById(R.id.mid);
            y = itemView.findViewById(R.id.yid);
            t = itemView.findViewById(R.id.timid);
            discription = itemView.findViewById(R.id.discid);
        }
    }

}


