package jw.io.web;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:restdbprops.properties")
public class RestDbClient implements Rest {

    @Value("${api.key}")
    private String apiKey;

    @Value("${data.endpoint}")
    private String dataEndpoint;

    @Override
    public String get() throws UnirestException {
        HttpResponse<String> response = Unirest.get(dataEndpoint)
                .header("x-apikey", apiKey)
                .header("cache-control", "no-cache")
                .asString();
        return response.getBody();
    }
}
