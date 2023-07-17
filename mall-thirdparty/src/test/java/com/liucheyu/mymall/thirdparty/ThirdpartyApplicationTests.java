package com.liucheyu.mymall.thirdparty;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootTest
@RequestMapping("mallproduct/category")
class ThirdpartyApplicationTests {

	@Autowired
	FirebaseAuth firebaseAuth;


	@Test
	void contextLoads() throws FirebaseAuthException {
//		String test = firebaseAuth.createCustomToken("test");
//		System.out.println(test);
	}

}
