package com.example.g10_excercise.restapiexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.g10_excercise.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RestApiActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RestListAdapter restListAdapter;
    private ArrayList<RestDataModel> restDataModels;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_recycle_view);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        restDataModels = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        parseJSON1();
        //parseJSON();
    }
    private void parseJSON1() {
        String apiurljson = "https://reqres.in/api/users?page=2";
        JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, apiurljson,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray =response.getJSONArray("data");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject data =jsonArray.getJSONObject(i);
                        String uname =data.getString("first_name");
                        String uemail=data.getString("email");
                        String imagesurl = data.getString("avatar");
                        restDataModels.add(new RestDataModel( imagesurl,"Name:  "+uname,"Email:  "+uemail));
                    }
                    recyclerView.setAdapter(new RestListAdapter(restDataModels));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

/*private void parseJSON(){
    String string = "https://reqres.in/api/users";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, string,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RestApiActivity.this,response,Toast.LENGTH_LONG).show();
                        parseData(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RestApiActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("name","morpheus");
                params.put("job","leader");
                return params;
            }
        };
       // RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void parseData(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.equals("true")) {
                String uname = jsonObject.getString("name");
                String uemail = jsonObject.getString("job");
                //String imagesurl = data.getString("avatar");
                restDataModels.add(new RestDataModel(uname, uemail));
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new RestListAdapter(restDataModels));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/
}