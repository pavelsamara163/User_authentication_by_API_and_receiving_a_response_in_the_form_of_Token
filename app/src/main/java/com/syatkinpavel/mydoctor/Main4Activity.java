package com.syatkinpavel.mydoctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static com.syatkinpavel.mydoctor.R.id.btnLogAct;
import static com.syatkinpavel.mydoctor.R.id.btnLogactiv2;

public class Main4Activity extends Activity implements View.OnClickListener {

    private ImageButton m4A;
    private Button LoginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        m4A = (ImageButton) findViewById(R.id.btnLogAct);
        m4A.setOnClickListener(this);

        LoginActivity = (Button) findViewById(R.id.btnLogactiv2);
        LoginActivity.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case btnLogAct:
                Intent m2a = new Intent(this, LoginActivity.class);
                startActivity(m2a);
                break;
            case btnLogactiv2:
                Intent lg = new Intent(this, LoginActivity.class);
                startActivity(lg);
                break;
            default:
                break;
        }
    }
}
