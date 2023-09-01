package com.tasks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.UUID;

@Controller
public class JSONControler {

    String request = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    String result = performRequest(request);

    public JSONControler() throws IOException {
    }


    @GetMapping(value = "/uuid")
    @ResponseBody
    public UUID uuidReturn(){
        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    @GetMapping(value = "/exchange")
    @ResponseBody
    public Curency getCurency(){
        Gson json = new GsonBuilder().create();
        Curency[] curencies = json.fromJson(result, Curency[].class);
        Curency curency = new Curency();
        Random random = new Random();
        curency = curencies[random.nextInt(curencies.length)];

        return curency;
    }

    @GetMapping(value = "/exchange/{currency}")
    @ResponseBody
    public Curency randomCurency(@PathVariable String currency){
        Gson json  = new GsonBuilder().create();
        Curency curency = null;
        Curency[] corencies = json.fromJson(result, Curency[].class);
        for (Curency c: corencies) {
            if (c.getCc().equalsIgnoreCase(currency)){
                curency = c;
            }
        }

        return curency;
    }

    public static String performRequest(String request) throws IOException {
        URL url = new URL(request);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];
            int i ;
            do{
                if ((i = br.read(buf)) > 0){
                    sb.append(new String(buf, 0, i));
                }
            }while (i > 0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
