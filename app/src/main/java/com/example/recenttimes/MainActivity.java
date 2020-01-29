package com.example.recenttimes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recenttimes.Model.Article;
import com.example.recenttimes.Model.News;
import com.example.recenttimes.api.APIClient;
import com.example.recenttimes.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String API_KEY="7030e16453934eccb9b883a89a548e76";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles=new ArrayList<>();
    private Adapter adapter;
    private String TAG=MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        /*recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);*/

        LoadJson();
    }

    public void LoadJson(){
        String country=Utils.getCountry();
        ApiInterface apiInterface= APIClient.getAPIClient().create(ApiInterface.class);
        Call<News> call;
        call=apiInterface.getNews(country,API_KEY);
//

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(response.isSuccessful() && response.body().getArticle()!=null){
                    if(!articles.isEmpty()){
                        articles.clear();
                    }
                    articles=response.body().getArticle();
                    adapter=new Adapter(articles,MainActivity.this);
                    recyclerView.setAdapter((adapter));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });





    }
}
