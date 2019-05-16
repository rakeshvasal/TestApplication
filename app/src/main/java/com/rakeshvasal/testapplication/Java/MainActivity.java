package com.rakeshvasal.testapplication.Java;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.rakeshvasal.testapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getData();

        TextView home = findViewById(R.id.home);
        TextView away = findViewById(R.id.away);
        home.setOnClickListener(this);
        away.setOnClickListener(this);

    }

    public void getData(View arg) {
        ApiInterface client = ApiClient.getClient().create(ApiInterface.class);
        Call<Data> call = client.getData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                Data data = (Data) response.body();
                Object awaydata = data.Teams.teamaway.Players;
                LinkedTreeMap awayteamtree = (LinkedTreeMap) awaydata;
                try {
                    Gson gson = new Gson();
                    String jsonString = gson.toJson(data);
                    Log.d("jsonstring", jsonString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                JsonObject jsonObject1 = gson.toJsonTree(awayteamtree).getAsJsonObject();
                JSONObject googlejson1 = null;
                try {
                    googlejson1 = new JSONObject(jsonObject1.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Iterator x = googlejson1.keys();
                JSONArray jsonArray = new JSONArray();
                List<Player> tobeaddedlist = new ArrayList<>();
                while (x.hasNext()) {
                    String key = (String) x.next();
                    try {

                        Player player = gson.fromJson(jsonObject1.get(key), Player.class);
                        tobeaddedlist.add(player);
                        jsonArray.put(jsonObject1.get(key));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                data.Teams.teamaway.playersList = tobeaddedlist;
                tobeaddedlist.clear();
                //Home Team Data Parse
                Object homedata = data.Teams.teamhome.Players;
                LinkedTreeMap homedatatree = (LinkedTreeMap) homedata;
                //Player player = (Player) datas.get();

                JsonObject jsonObject2 = gson.toJsonTree(homedatatree).getAsJsonObject();
                JSONObject googlejson2 = null;
                try {
                    googlejson2 = new JSONObject(jsonObject2.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Iterator x1 = googlejson2.keys();
                while (x1.hasNext()) {
                    String key = (String) x1.next();
                    try {
                        Player player = gson.fromJson(jsonObject2.get(key), Player.class);
                        tobeaddedlist.add(player);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                data.Teams.teamhome.playersList = tobeaddedlist;
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                t.getStackTrace();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.home:

            case R.id.away:

        }

    }

    public class MatchDetails extends AsyncTask<Void, Void, Void> {

        String url;

        MatchDetails(String url) {
            this.url = url;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String data = new ServiceCalls().makeServiceCall(url);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}

