package com.test;

import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 皮皮
 * @Date: 2024/8/12
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> array = Arrays.asList(
                "etc->hosts",
                "etc->kubernetes->ssl->certs",
                "root"
        );
        Map<String, Map> mapTree = arrayToMap(array);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(mapTree));
    }

  private static Map<String, Map> arrayToMap(List<String> array) {
        Map<String, Map> resMap = new HashMap<>();

        if (array.isEmpty()) {
            return resMap;
        }

        for (String s : array) {
            String[] stringArray = s.split("->");
            if (stringArray.length > 0) {
                Map<String, Map> tempMap = stringArrayToMap(stringArray);
                putMapToMap(resMap, tempMap);
            }
        }

        return resMap;
    }

    private static Map<String, Map> stringArrayToMap(String[] stringArray) {
        Map<String, Map> resMap = new HashMap<>();

        for (int i = stringArray.length-1; i >=0; i--) {

            if (i == stringArray.length - 1) {
                resMap.put(stringArray[i], new HashMap());
            } else {
                Map<String, Map> tempMap = new HashMap<>();
                tempMap.put(stringArray[i], resMap);
                resMap = tempMap;
            }
        }
        return resMap;
    }

    private static void putMapToMap(Map<String, Map> resMap, Map<String, Map> tempMap) {
        if (resMap.isEmpty()) {
            resMap.putAll(tempMap);
            return;
        }

        String s = (String) tempMap.keySet().toArray()[0];
        if (!resMap.containsKey(s)) {
            resMap.putAll(tempMap);
        } else {
            for (Map.Entry<String, Map> entry : resMap.entrySet()) {
                putMapToMap(entry.getValue(), tempMap.get(s));
            }
        }
    }


}
