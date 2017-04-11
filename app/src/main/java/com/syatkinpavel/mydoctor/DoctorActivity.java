package com.syatkinpavel.mydoctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.syatkinpavel.mydoctor.R.id.button2;
import static com.syatkinpavel.mydoctor.R.id.button3;
import static com.syatkinpavel.mydoctor.R.id.button4;

/**
 * Created by Павел on 11.11.2016.
 */

public class DoctorActivity extends Activity implements View.OnClickListener{

    private Button writing_the_recipe;
    private Button search;
    private Button history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorscreen);


        writing_the_recipe = (Button) findViewById(button2);
        writing_the_recipe.setOnClickListener(this);

        search = (Button) findViewById(button3);
        search.setOnClickListener(this);

        history = (Button) findViewById(button4);
        history.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                Intent recept = new Intent(this, Writing_recipe.class);
                startActivity(recept);
                break;
            case R.id.button3:
                Intent search = new Intent(this, SearchActivity.class);
                startActivity(search);
                break;
            case R.id.button4:
                Intent history = new Intent(this, PatientActivity.class);
                startActivity(history);
                break;
            default:
                break;
        }
    }
}

