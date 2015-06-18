package com.mycompany.fragwithrecyclerviewjun17;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);

        ((TextView) findViewById(R.id.bactivity_display)).setText(name);

        Toolbar toolbar = (Toolbar) findViewById(R.id.bactivity_actionbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_b, menu);
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
        Toast.makeText(BActivity.this, "Search in B", Toast.LENGTH_SHORT).show();
    }
}
