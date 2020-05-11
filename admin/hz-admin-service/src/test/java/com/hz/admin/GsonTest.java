package com.hz.admin;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Classname GsonTest
 * @Description TODO
 * @Date 2019-08-01 21:56
 * @Created by hzong
 */
public class GsonTest {

    public static void main(String[] args) throws InterruptedException {
        String founderJson = "[{'name': 'Christian','flowerCount': 1}, {'name': 'Marcus', 'flowerCount': 3}, {'name': 'Norman', 'flowerCount': 2}]";

        Gson gson = new Gson();
        String zb = "1";
        int i = 0;
        while (true){
            zb+="2";

//            Type founderListType = new TypeToken<ArrayList<Object>>(){}.getType();
//
//            List founderList = gson.fromJson(founderJson, founderListType);
//            if(i % 10000 == 0){
//                TimeUnit.SECONDS.sleep(1L)
//                ;
//            }
        }
    }
}
