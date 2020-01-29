package com.example.recenttimes;

import android.app.DownloadManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.recenttimes.Model.Article;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder > {
        private List<Article>articles;
        private Context context;
        private OnItemClickListener onItemClickListener;

    public Adapter(List<Article> articles, Context context) {
        this.articles=articles;
        this.context=context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
//        return new MyViewHolder(view,onItemClickListener);
        return new MyViewHolder(view);
//        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holders, int position) {
        final MyViewHolder holder=holders;
        Article model= articles.get(position);

        RequestOptions requestOptions=new RequestOptions();
//        requestOptions.placeholder(Utils.getRandomDrawbleColor());

        
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }


    public interface OnItemClickListener{

        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Erased implements View.OnItemClickListener
        TextView title,desc,author,published_ad,source,time;
        ImageView imageView;
        ProgressBar progressBar;
        OnItemClickListener onItemClickListener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener((View.OnClickListener) this);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
            author=itemView.findViewById(R.id.author);
            published_ad=itemView.findViewById(R.id.publishedAt);
            source=itemView.findViewById(R.id.source);
            time=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.img);
            progressBar=itemView.findViewById(R.id.progress_load_photo);

                    this.onItemClickListener=onItemClickListener;
        }


        public void onClick(View v){

            onItemClickListener.onItemClick(v,getAdapterPosition());
        }




    }

}


