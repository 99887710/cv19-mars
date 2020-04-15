package jw.io.web;

public interface Rest<T>{
    T get();
    T get(String queryParams);
    T post(String body);
    T put(String id, String body);
}
