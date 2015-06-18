package com.mycompany.fragwithrecyclerviewjun17;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;


public class MainActivity extends AppCompatActivity implements MainFragment.Callbacks {
    public static final String EXTRA_NAME = "com.mycompany.fragwithrecyclerviewjun17.NAME";

    OnClickListener sd = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String city = ((TextView) findViewById(R.id.mainactivity_display)).getText().toString();

            MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainactivity_fragment);
            mainFragment.getCity(city);
        }
    };

    OnClickListener startActivityB = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, BActivity.class);
            intent.putExtra(EXTRA_NAME, "Complicated");

            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mainactivity_actionbar);
        setSupportActionBar(toolbar);

        MainFragment mainFragment = MainFragment.newInstance("Hello");

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.mainactivity_fragment, mainFragment);
        ft.commit();

        Button send = (Button) findViewById(R.id.mainactivity_send);
        send.setOnClickListener(sd);

        Button start = (Button) findViewById(R.id.mainactivity_start);
        start.setOnClickListener(startActivityB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case(R.id.action_settings):
                return true;
            case(R.id.action_search):
                handleSearch();
                return true;
            default:
                super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }

    private void handleSearch() {
        Toast.makeText(MainActivity.this, "Search clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setHomePage(String name) {

        if(name != null && !name.isEmpty()) {
            ((TextView) findViewById(R.id.mainactivity_display)).setText(name);
        }
    }
}
