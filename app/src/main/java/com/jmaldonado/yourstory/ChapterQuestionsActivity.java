package com.jmaldonado.yourstory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class ChapterQuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_questions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.chapter_question_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.check_add_layout);
        CheckBox checkBox = new CheckBox(this);
        checkBox.setTag("1");
        checkBox.setText("What is your earliest memory?");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("2");
        checkBox.setText("Tell me about your parents.");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("3");
        checkBox.setText("Tell me about your brothers and sisters.");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("4");
        checkBox.setText("Tell me about your grandparents.");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("5");
        checkBox.setText("What was the neighbourhood you grew up in like?");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("6");
        checkBox.setText("Tell me a funny childhood memory");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("7");
        checkBox.setText("Tell me about a sad childhood memory.");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("8");
        checkBox.setText("Tell me about a memorable holiday from your childhood?");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("9");
        checkBox.setText("What was your first school like?");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("10");
        checkBox.setText("What were your favourite and least favourite subjects at school?");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("11");
        checkBox.setText("What did you want to be when you grew up?");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
        checkBox = new CheckBox(this);
        checkBox.setTag("12");
        checkBox.setText("Describe your closest friend from childhood?");
        checkBox.setTextSize(18);
        checkBox.setPadding(5,30,5,30);
        parentLayout.addView(checkBox);
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
}
