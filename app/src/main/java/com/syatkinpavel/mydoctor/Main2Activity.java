package com.syatkinpavel.mydoctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static com.syatkinpavel.mydoctor.R.id.btnLOgActiv;
import static com.syatkinpavel.mydoctor.R.id.btnm2A;

public class Main2Activity extends Activity implements View.OnClickListener{
    private ImageButton m2A;
    private Button loginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        m2A = (ImageButton) findViewById(R.id.btnm2A);
        m2A.setOnClickListener(this);

        loginActivity = (Button) findViewById(R.id.btnLOgActiv);
        loginActivity.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case btnm2A:
                Intent m2a = new Intent(this, Main3Activity.class);
                startActivity(m2a);
                break;
            case btnLOgActiv:
                Intent lg = new Intent(this, LoginActivity.class);
                startActivity(lg);
                break;
            default:
                break;
        }
    }
}
