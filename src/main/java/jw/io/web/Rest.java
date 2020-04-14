package jw.io.web;

public interface Rest<T>{
    T get();
    T get(String queryParams);

}
