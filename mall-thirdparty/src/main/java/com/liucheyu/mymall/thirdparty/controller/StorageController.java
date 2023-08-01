package com.liucheyu.mymall.thirdparty.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.liucheyu.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class StorageController {

    @Autowired
    FirebaseAuth firebaseAuth;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/storage_token")
    public R getStorageToken() throws FirebaseAuthException {
        String uid = "test";

        Optional<UserRecord> userOp = getUser(uid);
        if (userOp.isEmpty()) {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setUid(uid)
                    .setDisabled(false);
            FirebaseAuth.getInstance().createUser(request);
        }

        String redisKey = "firebase_uid".concat(uid);
        Object o = redisTemplate.opsForValue().get(redisKey);
        String token;
        if (o == null) {
            token = firebaseAuth.createCustomToken("test");
            redisTemplate.opsForValue().set(redisKey, token, Duration.ofSeconds(60 * 59));
        } else {
            token = o.toString();
        }

        return R.ok().put("token", token);
    }

    @PostMapping("/check_idtoken")
    public R checkIdToken(@RequestBody Map<String, String> req) throws FirebaseAuthException {
        if (req.get("idToken") == null) {
            return R.ok().put("success", false);
        }

        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(req.get("idToken"));
        String uid = decodedToken.getUid();
        if (!uid.equals("test")) {
            return R.error(400,"idToken not found");
        }

        return R.ok().put("success", true);
    }

    public Optional<UserRecord> getUser(String uid) {
        UserRecord userRecord;
        try {
            userRecord = FirebaseAuth.getInstance().getUser(uid);
        } catch (Exception ex) {
            return Optional.empty();
        }

        if (userRecord == null) {
            return Optional.empty();
        }

        return Optional.of(userRecord);
    }

}
