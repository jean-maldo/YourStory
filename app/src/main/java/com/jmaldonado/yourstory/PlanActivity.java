package com.jmaldonado.yourstory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import core.Chapter;
import helper.ChapterDividerItemDecoration;
import helper.ChapterViewAdapter;

public class PlanActivity extends AppCompatActivity {

    private ChapterViewAdapter adapter;
    private List<Chapter> chapterList = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        Toolbar toolbar = (Toolbar) findViewById(R.id.new_story_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new ChapterViewAdapter(this, chapterList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new ChapterDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 10));
        recyclerView.setAdapter(adapter);
        prepareChapters();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_new_story, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return false;
    }

    /**
     * Adding few albums for testing
     */
    private void prepareChapters() {
        chapterList.add(new Chapter("Chapter 1", "No questions selected"));
        chapterList.add(new Chapter("Chapter 2", "No questions selected"));
        chapterList.add(new Chapter("Chapter 3", "No questions selected"));
        chapterList.add(new Chapter("Chapter 4", "No questions selected"));
        chapterList.add(new Chapter("Chapter 5", "No questions selected"));

        adapter.notifyDataSetChanged();
    }
}
