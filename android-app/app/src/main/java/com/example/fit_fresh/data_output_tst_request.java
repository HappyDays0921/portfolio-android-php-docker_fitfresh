package com.example.fit_fresh;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class data_output_tst_request extends StringRequest {

    //final static private String URL="http://computernano.dothome.co.kr/data_output.php";
    final static  private String URL = "http://10.0.2.2:8080/data_output.php";

    private Map<String, String> map;
    public data_output_tst_request(String userName, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);

        map = new HashMap<>();
        map.put("userName", userName);
        //map.put("carbo",carbo);
        //map.put("protein",protein);
        //map.put("fat",fat);




    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError{
        return map;
    }



}
