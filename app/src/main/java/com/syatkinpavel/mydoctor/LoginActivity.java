package com.syatkinpavel.mydoctor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends Activity {
         public EditText login;
        public EditText password ;
        private ProgressDialog dialog;



    public static String sash256(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageButton btn = (ImageButton) findViewById(R.id.button1);
        login = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
      //cbRemember = (CheckBox) findViewById(R.id.rememberMe);


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               new RequestTask().execute("https://tinkoffwm.ru/api/login");
            }
        });

        SharedPreferences settings = getPreferences(0);


    }


    class RequestTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                //создаем запрос на сервер
                DefaultHttpClient client = new DefaultHttpClient();

                ResponseHandler<String> res = new BasicResponseHandler();
                //он у нас будет посылать post запрос
                HttpPost postMethod = new HttpPost(params[0]);
                //будем передавать два параметра
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);

                nameValuePairs.add(new BasicNameValuePair("login", login.getText().toString()));

                nameValuePairs.add(new BasicNameValuePair("password",sash256( password.getText().toString())));


                //собераем их вместе и посылаем на сервер
                postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                //получаем ответ от сервера
                try {
                    String response = client.execute(postMethod, res);
                    Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
                    intent.putExtra(SecondActivity.JsonURL, response.toString());
                    startActivity(intent);
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                System.out.println("Exp=" + e);
            }
            return null;
        }



        @Override
        protected void onPostExecute(String result) {

            dialog.dismiss();
            super.onPostExecute(result);
        }

        @Override
        protected void onPreExecute() {

            dialog = new ProgressDialog(LoginActivity.this);
            dialog.setMessage("Загружаюсь...");
            dialog.setIndeterminate(true);
            dialog.setCancelable(true);
            dialog.show();
            super.onPreExecute();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
     /*   String loginss = login.getText().toString().trim();
        String passwordss = password.getText().toString().trim();
        SharedPreferences settings = getPreferences(0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Login", loginss);
        editor.putString("Password", passwordss);

        editor.commit();*/
    }

}