package org.guduo.textming.webView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @athor Lijian
 * @date 2016年04月22日
 */
public class s {
    public static void main(String[] args) {
        ArrayList List = new ArrayList<String>();
        List.add("dsdsdsd");
        getListValue(List);
        System.out.println(List.size());
        String s = "country";
        getCountry(s,1);
        System.out.println(s);
        Integer n = 1;
        getNumber(n,1);
        System.out.println(n);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("sdsadsa",List);
        getMap(map);
        System.out.println(map.size());

    }

    private static void getMap(HashMap<String, Object> map) {
        ArrayList List = new ArrayList<String>();
        List.add("ds");
        map.put("sdads",List);
    }

    private static void getNumber(Integer n, int i) {
        if (i==1){
            n=100;
        }
    }

    private static void getCountry(String s, int i) {
        if (i==1){
            s="china";
        }
    }

    private static void getListValue(ArrayList list) {
        list.add("sadasdsadsadasdas");
    }
}
