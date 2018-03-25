package com.example.senalalumiere.petit_bac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.senalalumiere.petit_bac.Activity.EquipeActivity;
import com.example.senalalumiere.petit_bac.Activity.JoueurActivity;
import com.example.senalalumiere.petit_bac.Activity.PartieActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jActivity (View view){
        startActivity(new Intent(this, JoueurActivity.class));
    }
    public void eActivity (View view){
        startActivity(new Intent(this, EquipeActivity.class));
    }
    public void pActivity (View view) { startActivity(new Intent(this, PartieActivity.class)); }

}
