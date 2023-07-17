package com.liucheyu.mymall.thirdparty.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class WebConfig {

    @Value("${firebase.serviceAccountKey}")
    String firebaseServiceAccountKey;
    @Value("${firebase.databaseUrl}")
    String firebaseDatabaseUrl;

    @Bean
    public FirebaseApp getFirebaseApp() throws IOException {
        FileInputStream refreshToken = new FileInputStream(firebaseServiceAccountKey);

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .setDatabaseUrl("https://".concat(firebaseDatabaseUrl).concat("firebaseio.com/"))
                .build();

        FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
        return firebaseApp;
    }

    @Bean
    public FirebaseAuth getFirebaseAuth(FirebaseApp firebaseApp) {
        return FirebaseAuth.getInstance(firebaseApp);
    }
}
