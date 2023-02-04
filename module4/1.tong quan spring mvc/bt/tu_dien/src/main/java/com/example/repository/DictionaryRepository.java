package com.example.repository;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionary ;
    static {
        dictionary=new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("pen", "cây bút");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
    }
    @Override
    public String search(String string) {
        String result = dictionary.get(string);
        if(result!=null){
            return result;
        } else {
            return null;
        }
    }
}
