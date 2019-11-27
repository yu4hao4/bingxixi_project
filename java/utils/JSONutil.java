package utils;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class JSONutil {
    public static JSONObject getJSON(Object obj) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",obj);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }
    public static JSONObject getJSONAsInputStream(InputStream inputStream) {
        JSONObject jsonObject = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            String result = "";
            int respInt = inputStreamReader.read();
            while(respInt!=-1) {
                result += (char) respInt;
                respInt = inputStreamReader.read();
            }
            jsonObject = JSONObject.parseObject(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
