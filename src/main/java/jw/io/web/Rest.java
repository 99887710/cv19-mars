package jw.io.web;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface Rest {
    String get() throws UnirestException;
}
