package com.example.androidproje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CASPER on 9.05.2017.
 */
public class Kategori extends Activity {
    TextView oyunmodu;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.kategori_layout);
       oyunmodu= (TextView)findViewById(R.id.kategoritext1);
        final ImageView iv=(ImageView) findViewById(R.id.imageView5);


    }
    public void Islem1(View v)
    {
        if(v.getId()==R.id.islemBtn){
            Intent intent=new Intent(getApplicationContext(), Islem.class);
           String username=this.getIntent().getExtras().getString("username");
            intent.putExtra("username",username);
            startActivity(intent);

        }
    }
    public void Kelime1(View v)
    {
        if(v.getId()==R.id.kelimeBtn){
            Intent intent=new Intent(getApplicationContext(), Kelime.class);
            startActivity(intent);

        }
    }

}
