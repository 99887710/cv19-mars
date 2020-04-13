package jw.io.web;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RestDbClient implements Rest {

    @Override
    public String get() throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://cv19mars-9e51.restdb.io/rest/case-data-model")
                .header("x-apikey", "*****************************")
                .header("cache-control", "no-cache")
                .asString();
        return response.getBody();
    }
}
