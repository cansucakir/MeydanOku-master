package com.example.androidproje;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Asus on 18.05.2017.
 */
public class SaveTest extends Islem {

    HashMap<String, String> test;
    String username;
    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();

    public SaveTest(HashMap test, String username) {
        this.test = test;
        this.username=username;
    }


    public void Kaydet() {

        ArrayList<String> array = new ArrayList<>();
        array = new ArrayList<>(test.keySet());


        for (int i = 0; i <array.size(); i++) {

            String sorup = array.get(i);
            String cevapp = test.get(sorup);
            new TestKaydet().execute(sorup,cevapp,username);
        }
    }




    class TestKaydet extends AsyncTask<String, String, String> {

        String TEST_URL;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
         TEST_URL = "http://challangerace.000webhostapp.com/Test.php";
        }

        @Override
        protected String doInBackground(String... args) {
            // here Check for success tag int success;

            boolean success = false;
            String sorupp = args[0];
            String cevappp= args[1];
            String username = args[2];
            String cozuldumu="no";

            List<NameValuePair> data = new ArrayList<>();


            data.add(new BasicNameValuePair("soru", sorupp));
            data.add(new BasicNameValuePair("cevap", cevappp));
            data.add(new BasicNameValuePair("cozuldumu",cozuldumu));
            data.add(new BasicNameValuePair("username",username));

            try {
                    JSONObject json = jsonParser.makeHttpRequest(TEST_URL, "POST", data);
                    success = json.getBoolean("success");

                } catch (Exception e) {
                    return "something wrong";
                }
                if (success == true) {
                    return "Kaydedildi";
                } else return "Bir sorunla karşılaşıldı";

            }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);


        }

    }

}