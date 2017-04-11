package com.syatkinpavel.mydoctor;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


public class NavigationActiv extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CustomAdapter adapter;
    ViewPager viewpager;
    public static final String TOKEN = "access_token";
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
            Intent intentre = new Intent(NavigationActiv.this,MainActivity.class);
            startActivity(intentre);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewpager = (ViewPager)findViewById(R.id.viewPager);
        adapter = new CustomAdapter(this);
        viewpager.setAdapter(adapter);

        first_name = (TextView) findViewById(R.id.first_name_user);
        lastname = (TextView) findViewById(R.id.last_name_user);
        balance = (TextView) findViewById(R.id.balance_user);
        recept = (TextView) findViewById(R.id.recipe_user);


        Bundle extras = getIntent().getExtras();
        String json = extras.getString(JsonUser);
        USER(json);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
