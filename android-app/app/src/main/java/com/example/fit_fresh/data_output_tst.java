package com.example.fit_fresh;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class data_output_tst extends AppCompatActivity {

    String userNames, userAges, userIDs;
    String userName = "fuckyou", userAge, userID;
    String carbo, protein, fat;

    protected void onCreate(Bundle savedInsatnace) {
        setContentView(R.layout.data_output_tst);
        super.onCreate(savedInsatnace);


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String responses) {
                try {
                    //서버의 응답을 JSONOBJECT로 변환한다.
                    JSONObject jasonObject = new JSONObject(responses);
                    //원래는 사용자의 아이디를 입력받아서 데이터베이스와 비교한 이후 데이터를 가져와야 하지만
                    //현재 상황은 sharedreference로
                    SharedPreferences sharedPreferences = getSharedPreferences("INFO", MODE_PRIVATE);
                    //userName = sharedPreferences.getString("userName", "name_error");
                    //String age = sharedPreferences.getString("userAge", "age_error");
                    //String id = sharedPreferences.getString("userID", "id_error");

                    //userName = jasonObject.getString("name");
                    //userAge = jasonObject.getString("age");
                    // userID = jasonObject.getString("id");
                    //탄수화물
                    /*carbo = jasonObject.getString("carbo");
                    //단백질
                    protein = jasonObject.getString("protein");
                    //지방
                    fat = jasonObject.getString("fat");*/
                    //boolean success
                    boolean success=jasonObject.getBoolean("success");
                    if (success)
                    {
                        //userName = jasonObject.getString("userNames");
                        carbo= jasonObject.getString("carbo");
                        protein=jasonObject.getString("protein");
                        fat= jasonObject.getString("fat");

                    }else {
                        Toast.makeText(getApplicationContext(),"받아오기 실패", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        //userName="fuckyou";
        data_output_tst_request data= new data_output_tst_request(userName,responseListener);
        RequestQueue queue= Volley.newRequestQueue(data_output_tst.this);
        queue.add(data);

    }


}
