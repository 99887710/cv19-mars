package jw.io.web;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Component
@PropertySource("classpath:firestoreprops.properties")
@Log
public class FirestoreDbClient implements Rest<List<Map<String, Object>>> {

    @Value("${firestore.key.file.path}")
    private String keyFilePAth;

    @Value("${firestore.db.url}")
    private String dbUrl;

    private Firestore db;

    @PostConstruct
    public void FirestoreDbClient() {
        try (FileInputStream serviceAccount = new FileInputStream(keyFilePAth)){
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(dbUrl)
                    .build();
            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Map<String, Object>> get() {
        List<Map<String, Object>> response = null;
        ApiFuture<QuerySnapshot> query = db.collection("cases").get();
        try {
            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
            response = documents.stream()
                    .map(d -> d.getData())
                    .collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return response != null ? response : null;
    }

    @Override
    public List<Map<String, Object>> get(String queryParams) {
        return null;
    }

    @Override
    public List<Map<String, Object>> post(String body) {
        return null;
    }
}
