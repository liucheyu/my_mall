package com.liucheyu.mymall.thirdparty.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.liucheyu.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StorageController {

    @Autowired
    FirebaseAuth firebaseAuth;


    @GetMapping("/storageToken")
    public R getStorageToken() throws FirebaseAuthException {

        String token = firebaseAuth.createCustomToken("test");
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);

        return R.ok().put("token", token);
    }

}
