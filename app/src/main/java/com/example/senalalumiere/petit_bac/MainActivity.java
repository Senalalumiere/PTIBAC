package com.example.senalalumiere.petit_bac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jActivity (View view){
        startActivity(new Intent(this, com.example.senalalumiere.petit_bac.classes.JoueurActivity.class));
    }
}
