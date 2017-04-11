package com.syatkinpavel.mydoctor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павел on 20.12.2016.
 */

public class SecondActivity extends Activity {
    public TextView responses;
    public TextView errors;
    private ProgressDialog dialog;
    public static final String TOKEN = "access_token";
    public static  final String ERROR = "error";

    public static String JsonURL;




    public void JSONURL(String result) {

        try {
            JSONObject json = new JSONObject(result);
            responses.setText((CharSequence) json.get(TOKEN));
            }catch (JSONException e) {
            Intent intentre = new Intent(SecondActivity.this,MainActivity.class);
            startActivity(intentre);
                }


    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


       // String txtotvet = getIntent().getStringExtra();
        if(TOKEN != null) {
            new RequestTask().execute("https://tinkoffwm.ru/api/userInfo");
        }
       else {
            Intent intentre = new Intent(SecondActivity.this,MainActivity.class);
            startActivity(intentre);
        }
        responses = (TextView) findViewById(R.id.response);

        Bundle extras = getIntent().getExtras();
        String json = extras.getString(JsonURL);
        JSONURL(json);

      /* responses.setText(json);
        token.setText("access_token:" + txtotvet.contains("access_token"));
        responses.setText(json);
        respon.setText(respon.getText().toString() + "  " + respon + responses + token);*/

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
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);


                nameValuePairs.add(new BasicNameValuePair(TOKEN,responses.getText().toString()));
                //собераем их вместе и посылаем на сервер
                postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                //получаем ответ от сервера
                try {
                    String response = client.execute(postMethod, res);

                    //посылаем на вторую активность полученные параметры
                    Intent intent = new Intent(SecondActivity.this, NavigationActiv.class);
                    //то что куда мы будем передавать и что, putExtra(куда, что);
                    intent.putExtra(NavigationActiv.JsonUser, response.toString());
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

            dialog = new ProgressDialog(SecondActivity.this);
            dialog.setMessage("Загружаюсь...");
            dialog.setIndeterminate(true);
            dialog.setCancelable(true);
            dialog.show();
            super.onPreExecute();
        }
    }

}




