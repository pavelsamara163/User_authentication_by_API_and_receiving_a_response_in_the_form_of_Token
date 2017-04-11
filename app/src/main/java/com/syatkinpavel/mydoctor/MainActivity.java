package com.syatkinpavel.mydoctor;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.syatkinpavel.mydoctor.R.id.mydoctor;



public class MainActivity extends Activity implements View.OnClickListener{

    private Button btnDoctor;
    private Button btnPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDoctor = (Button) findViewById(mydoctor);
        btnDoctor.setOnClickListener(this);

      /*  btnPatient = (Button) findViewById(mypatient);
       btnPatient.setOnClickListener(this);*/

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case mydoctor:
                Intent doctor = new Intent(this, Main2Activity.class);
                startActivity(doctor);
                break;
          /*  case mypatient:
                Intent patient = new Intent(this, PatientActivity.class);
                startActivity(patient);
                break;*/
            default:
                break;
        }
    }
    }





