package com.example.movie_recommender_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.movie_recommender_app.Adapter.RecyclerViewAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class ChooseMovie extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerAdapter;
    AsyncHttpClient client;
    Workbook workbook;
    List<String> titles, descriptions, imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_movie);

        String url ="https://github.com/palak1607/Movie_Recommender_Palak_Mahajan/blob/main/workbookListData.xlsx?raw=true";

        recyclerView = findViewById(R.id.ListOfData) ;

        titles = new ArrayList<>();
        descriptions = new ArrayList<>();;
        imageUrl = new ArrayList<>();


        client = new AsyncHttpClient();
        client.get(url, new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                Toast.makeText(ChooseMovie.this, "Download failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                Toast.makeText(ChooseMovie.this, "File downloaded successfully", Toast.LENGTH_SHORT).show();

                WorkbookSettings ws = new WorkbookSettings();
                ws.setGCDisabled(true);
                if (file != null) {
                    try {
                        workbook = workbook.getWorkbook(file);
                        Sheet sheet = workbook.getSheet(0);
                        for (int i = 0; i < sheet.getRows(); i++) {
                            Cell[] row = sheet.getRow(i);
                            titles.add(row[0].getContents());
                            descriptions.add(row[1].getContents());
                            imageUrl.add(row[2].getContents());
                        }
                        showData();

                        Log.d("TAG","onSuccess: " +titles );
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (BiffException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    private void showData() {
        recyclerAdapter = new RecyclerViewAdapter(this, titles, descriptions, imageUrl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
    }
}