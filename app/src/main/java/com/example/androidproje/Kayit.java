package com.example.androidproje;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CASPER on 9.05.2017.
 */
public class Kayit extends Fragment {
    private EditText user, pass;
    private Button bKayit;
    // Progress Dialog
    private ProgressDialog pDialog;
    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    InputStream is;
    String line=null;
    String result=null;

    private static final String REGISTER_URL = "http://challangerace.000webhostapp.com/Register.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.kayitol_layout,container,false);
        user = (android.widget.EditText)view.findViewById(R.id.username);
        pass = (EditText)view.findViewById(R.id.password);
        bKayit = (Button)view.findViewById(R.id.kayitol);

        bKayit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String Username = user.getText().toString();
                String Password = pass.getText().toString();
                new AttemptLogin().execute(Username,Password);
            }
        });
        return view;
    }

   /* public void KayıtOl(View v) {

                String Username = user.getText().toString();
                String Password = pass.getText().toString();
                new AttemptLogin().execute(Username,Password);

                // here we have used, switch case, because on login activity you may
                // also want to show registration button, so if the user is new ! we can go the
                // registration activity , other than this we could also do this without switch
                // case.


    }*/


    class AttemptLogin extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog *
         */
        boolean failure = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Attempting for register...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // here Check for success tag int success;

            boolean success = false;
            String username = args[0];
            String password = args[1];


            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", username));
            params.add(new BasicNameValuePair("password", password));


            try {
                JSONObject json = jsonParser.makeHttpRequest(REGISTER_URL, "POST", params);
                success=json.getBoolean("success");

            }catch (Exception e){
                    return "something wrong";
            }
            if(success==true){
                return "Kayıt oldunuz";
            }else return "Kullanıcı adı daha önce alınmış";

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pDialog.dismiss();
            Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();


        }
    }

        /** * Once the background process is done we need to Dismiss the progress dialog asap * **/
        protected void onPostExecute(String message) {
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();

            pDialog.dismiss();
            if (message != null){
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
        }




  /*  public void Giris1(View v) {

        if (a.getText().toString().equals("admin") && b.getText().toString().equals("1234")) {
           Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            //yorum deneme yorumu
        }
        else
        {


            Log.w("IBR", "Kullanıcı adı yada şifre yanlış");
        }

    }*/

}

