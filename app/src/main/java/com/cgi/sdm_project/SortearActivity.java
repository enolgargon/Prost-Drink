package com.cgi.sdm_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AutoText;
import android.view.View;


public class SortearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparacionsorteo);
    }

    public void lanzarResultadoSorteo(View vs){
        Intent mIntent = new Intent(getApplicationContext(), ResultadoSorteoActivity.class);
        startActivity(mIntent);
    }
}
