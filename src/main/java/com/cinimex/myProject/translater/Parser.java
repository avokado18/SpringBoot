package com.cinimex.myProject.translater;

import com.cinimex.myProject.model.Word;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static String[] getWords(String str){
        return str.split("\\s*[^а-яА-ЯёЁ]+\\s*");
    }

    public static List<Word> JSONParser(String str) throws JSONException {
        JSONObject wordsJSON = new JSONObject(str);
        JSONArray jsonArray = wordsJSON.getJSONArray("words");
        List<Word> words = new ArrayList();
        try{
            for (int i = 0; i < jsonArray.length(); i++){
                Word word = new Word();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                word.setOriginal(jsonObject.getString("original"));
                word.setTranslated(jsonObject.getString("translated"));
                words.add(word);
            }

        } catch (JSONException e) {
            throw e;
        }
        return words;
    }
}
