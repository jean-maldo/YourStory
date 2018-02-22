package com.jmaldonado.yourstory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import core.Chapter;
import helper.ChapterDividerItemDecoration;
import helper.ChapterViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanFragment extends Fragment {
    private ChapterViewAdapter adapter;
    private List<Chapter> chapterList = new ArrayList<>();
    private RecyclerView recyclerView;
    public PlanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plan, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new ChapterViewAdapter(this.getActivity(), chapterList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new ChapterDividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL, 10));
        recyclerView.setAdapter(adapter);
        prepareChapters();

        return view;
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
