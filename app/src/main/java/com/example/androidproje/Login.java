package com.example.androidproje;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by CASPER on 9.05.2017.
 */
public class Login extends AppCompatActivity {
    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //   setSupportActionBar(toolbar);
        mSectionPageAdapter= new SectionPageAdapter(getSupportFragmentManager());

        //Set up the ViewPager with the sections adapter
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tablayout=(TabLayout)findViewById(R.id.tabs);
        tablayout.setupWithViewPager(mViewPager);
    }
 /*   public void Giriş1(View v)
    {
        if(v.getId()==R.id.girişBtn){
            Intent intent=new Intent(getApplicationContext(), Giris.class);
            startActivity(intent);

        }
    }
    public void Kayıt1(View v)
    {
        if(v.getId()==R.id.kayıtBtn){
            Intent intent=new Intent(getApplicationContext(), Kayit.class);
            startActivity(intent);

        }
    }
*/
 private void setupViewPager(ViewPager viewPager){
     SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
     adapter.addFragment(new Giris(),"GirişYap");
     adapter.addFragment(new Kayit(),"Kayıt Ol");
     viewPager.setAdapter(adapter);

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
