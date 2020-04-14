package jw.io.web;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:restdbprops.properties")
@Log
public class RestDbClient implements Rest<String> {

    @Value("${api.key}")
    private String apiKey;

    @Value("${data.endpoint}")
    private String dataEndpoint;

    private final String ERROR_RESPONSE = "request error";

    @Override
    public String get()  {
        return getHelper(null);
    }

    @Override
    public String get(String queryParams) {
        return getHelper(queryParams);
    }

    private String getHelper(String queryParams) {
        HttpResponse<String> response = null;
        log.info(String.format("query params - %s", queryParams));
        try {
            response = Unirest.get(dataEndpoint)
                    .header("x-apikey", apiKey)
                    .header("cache-control", "no-cache")
                    .queryString("q", queryParams)
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response != null ? response.getBody() : ERROR_RESPONSE;
    }
}
