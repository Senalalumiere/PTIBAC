package com.example.senalalumiere.petit_bac.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.senalalumiere.petit_bac.R;

/**
 * Created by Pezed on 25/03/2018.
 */

public class PartieActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipe_activity);
    }

    public void eActivity (View view){
        startActivity(new Intent(this, EquipeActivity.class));
    }

}
