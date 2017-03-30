package com.cinimex.myProject.translater;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

@Scope("singleton")
@Component
public class Translater {

    private static final String key = "trnsl.1.1.20161213T194815Z.5887fbeaa9f262e6.ae9c20cd6197275b52633082b967f9157e37daa6";
    private static final String uri = "https://translate.yandex.net/api/v1.5/tr.json/translate?";

    public static String translate (String translateString, String langFromTo){
        String urlStr = uri + "key=" + key + "&text=";
        try {
            URL urlObj = new URL(urlStr);
            HttpsURLConnection connection = (HttpsURLConnection)urlObj.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes("text=" + URLEncoder.encode(translateString, "UTF-8") + "&lang=" + langFromTo);

            InputStream response = connection.getInputStream();
            String json = new java.util.Scanner(response).nextLine();
            int start = json.indexOf("[");
            int end = json.indexOf("]");
            String translated = json.substring(start + 2, end - 1);
            return translated;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String[] getTranslated(String[] originals){
        String[] trans = new String[originals.length];
        for (int i = 0; i < originals.length; i++){
            trans[i] = translate(originals[i], "ru-en");
        }
        return trans;
    }
}
