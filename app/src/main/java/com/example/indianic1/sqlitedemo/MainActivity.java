package com.example.indianic1.sqlitedemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.indianic1.sqlitedemo.model.CustomerModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final SqliteDemoApp sqliteDemoApp = (SqliteDemoApp) getApplicationContext();
        final DBHelper dbHelper = sqliteDemoApp.getDbHelper();
        CustomerModel customerModel = new CustomerModel("1", "ABC132", "DEF");
        dbHelper.deleteSingleEmployee(1);
        CustomerModel customerModel11 = new CustomerModel();
        customerModel11 = dbHelper.getcustomerInfo(1);
        if (customerModel11 != null) {
            Toast.makeText(getApplicationContext(), customerModel11.getName(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_LONG).show();
        }


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
