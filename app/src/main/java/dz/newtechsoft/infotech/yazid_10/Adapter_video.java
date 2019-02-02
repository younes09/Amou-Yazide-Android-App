package dz.newtechsoft.infotech.yazid_10;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import com.example.infotech.yazid_10.R;
import com.squareup.picasso.Picasso;

/**
 * Created by younes on 15/07/2018.
 */

public class Adapter_video extends RecyclerView.Adapter<Adapter_video.myViewHolder> {

    Context mContext;
    List<Item_video> mData;

    public Adapter_video(Context mContext, List<Item_video> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.item_video,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {

        //holder.bg.setImageResource(mData.get(position).getBg());
        //Drawable drawable = LoadImageFromWebOperations(mData.get(position).getBg());
        //holder.bg.setImageDrawable(drawable);
        holder.setImageUrl(mData.get(position).getBg());
        holder.tv_titel.setText(mData.get(position).getTitel());
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ActivityVideoWatch.class);
                intent.putExtra("VIDEO_ID",mData.get(position).getUrl());
                intent.putExtra("Categorie",mData.get(position).getCategory());
                mContext.startActivity(intent);
                Toast.makeText(mContext, mData.get(position).getTitel(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    private Drawable LoadImageFromWebOperations(String url)
    {
        try{
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        }catch (Exception e) {
            System.out.println("Exc="+e);
            return null;
        }
    }

    public class myViewHolder extends  RecyclerView.ViewHolder {
        ImageView bg;
        TextView tv_titel;
        LinearLayout ll;

        public myViewHolder(View itemView){
            super(itemView);
            bg = itemView.findViewById(R.id.bgid);
            tv_titel = itemView.findViewById(R.id.titelid);
            ll = (LinearLayout)itemView.findViewById(R.id.tovidioid);
        }

        public void setImageUrl(String url){
            Picasso.with(mContext).load(url).placeholder(R.mipmap.ic_launcher) // optional
                    .error(R.mipmap.ic_launcher) //if error
                    .into(bg,new com.squareup.picasso.Callback(){


                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {

                        }
                    });

        }
    }
}
