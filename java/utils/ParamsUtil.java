package utils;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSONObject;
import com.sun.tools.javac.util.Convert;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ParamsUtil {
    private JSONObject jsonObject = null;
    public ParamsUtil(HttpServletRequest request) {
        this.getJSONObject(request);
    }
    public  <T> T postGetParams(Class<T> clazz) throws IOException {
        if(jsonObject == null || jsonObject.isEmpty()) {
            return null;
        }
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Map<String, Method> methodMap = new HashMap<String,Method>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if(name.contains("set")) {
                name = name.substring(3).toLowerCase();
                methodMap.put(name, method);
            }
        }
        for (String key:jsonObject.keySet()
        ) {
            Method m = methodMap.get(key);
            Class<?>[] name = m.getParameterTypes();
            Class<?> c = name[0];
            Object object = jsonObject.get(key);
            String str =  (String)jsonObject.get(key);
            if (c == Integer.class) {
                object = new Integer(str);
            }else if(c == Float.class) {
                object = new Float(str);
            }else if(c == Double.class) {
                object = new Double(str);
            }else if(c == String.class) {
                object = str;
            }else if(c == Long.class) {
                object = new Long(str);
            }else if(c == Boolean.class) {
                object = new Boolean(str);
            }
            m.setAccessible(true);
            try {
                m.invoke(t, object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return t;
    }
    public Object postGetParams(String key) throws IOException {
        Object object = null;
        if(jsonObject == null || jsonObject.isEmpty()) {
            return null;
        }
        object = jsonObject.get(key);
        return object;
    }
    private JSONObject getJSONObject(HttpServletRequest request) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(request.getInputStream());
            byte[] b = new byte[1024];
            String str = "";
            StringBuffer sb = new StringBuffer(str);
            int len = 0;
            while ((len = bufferedInputStream.read(b)) != -1) {
                sb.append(new String(b, 0, len,"utf-8"));
            }
            jsonObject = JSONObject.parseObject(sb.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    public JSONObject getJSON(Object obj) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",obj);
        JSONObject jsonObje = new JSONObject(map);
        return jsonObje;
    }
}
