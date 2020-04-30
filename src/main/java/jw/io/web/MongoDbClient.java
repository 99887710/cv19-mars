package jw.io.web;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@PropertySource("classpath:mongodbprops.properties")
@Log
public class MongoDbClient {

    @Value("${mongodb.data.endpoint}")
    private String dataEndpoint;

    @PostConstruct
    public void init(){
        System.out.println(dataEndpoint);
        MongoClient mongoClient = MongoClients.create(dataEndpoint);
        MongoDatabase database = mongoClient.getDatabase("test");
    }
}
