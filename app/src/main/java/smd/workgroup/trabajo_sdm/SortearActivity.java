package smd.workgroup.trabajo_sdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AutoText;
import android.view.View;

import sdm.workgroup.trabajo_sdm.ResultadoSorteoActivity;

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
