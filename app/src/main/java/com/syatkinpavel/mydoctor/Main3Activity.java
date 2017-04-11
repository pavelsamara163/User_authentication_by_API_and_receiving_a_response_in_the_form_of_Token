package com.syatkinpavel.mydoctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static com.syatkinpavel.mydoctor.R.id.btn3Activ;
import static com.syatkinpavel.mydoctor.R.id.btnLogActivity;

public class Main3Activity extends Activity implements View.OnClickListener{

    private ImageButton m3A;
    private Button loginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        m3A = (ImageButton) findViewById(R.id.btn3Activ);
        m3A.setOnClickListener(this);

        loginActivity = (Button) findViewById(R.id.btnLogActivity);
        loginActivity.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case btn3Activ:
                Intent m2a = new Intent(this, Main4Activity.class);
                startActivity(m2a);
                break;
            case btnLogActivity:
                Intent lg = new Intent(this, LoginActivity.class);
                startActivity(lg);
                break;
            default:
                break;
        }
    }
}
