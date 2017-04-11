package com.syatkinpavel.mydoctor;

import android.app.Activity;


public class UserInfo extends Activity {
   /* public static final String TOKEN = "access_token";
    public TextView first_name;
    public TextView lastname ;
    public TextView balance ;
    public TextView recept ;

    public static final String NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String BALANCE = "balance";
    public static final String RECIPE = "recept";
    public static final String USERINFO = "userInfo";
    public static String JsonUser ;



    public void USER(String result) {
        try {
            JSONObject json = new JSONObject(result);
             JSONObject user = json.getJSONObject(USERINFO);
            String name = user.getString(NAME);
            String last = user.getString(LAST_NAME);
            String balances = user.getString(BALANCE);
            String recipe = user.getString(RECIPE);

             first_name.setText("Имя:" + " " +  name);
             lastname.setText("Фамилия:" + " " +  last);
             balance.setText("Баланс:" + " " +  balances);
             recept.setText("Рецепт:" + " " +  recipe);

        }catch (JSONException e) {
            Intent intentre = new Intent(UserInfo.this,MainActivity.class);
            startActivity(intentre);
        }

    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
                first_name = (TextView) findViewById(R.id.first_name_user);
                lastname = (TextView) findViewById(R.id.last_name_user);
                balance = (TextView) findViewById(R.id.balance_user);
                recept = (TextView) findViewById(R.id.recipe_user);


                  Bundle extras = getIntent().getExtras();
                  String json = extras.getString(JsonUser);
                  USER(json);




        }*/



    }


