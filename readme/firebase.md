# firebase


## 使用spring boot(不確定是否可用)

管理登入認證的maven依賴
```
<dependency>
  <groupId>com.google.firebase</groupId>
  <artifactId>firebase-admin-spring-boot-starter</artifactId>
  <version>1.2.1</version>
</dependency>
```

application.properties
```properties
firebase.credential.path=/path/to/service-account.json
```
或yaml
```yaml
firebase:
  credential:
    path: /path/to/service-account.json
```

@Autowire引入
```java
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

class xxx {
    @Autowired
    private FirebaseAuth firebaseAuth;
    
    // 获取自定义令牌
    public String getCustomToken(String uid) throws Exception {
        FirebaseToken customToken = firebaseAuth.createCustomToken(uid);
        return customToken.getToken();
    }
}
```



## 不使用spring boot starter時

管理登入認證的maven依賴
```xml
<dependency>
  <groupId>com.google.firebase</groupId>
  <artifactId>firebase-admin</artifactId>
  <version>9.2.0</version>
</dependency>
```

firebase admin sdk設定
```java
class xxx{
    @Bean
    public FirebaseApp getFirebaseApp() {
        FileInputStream refreshToken = new FileInputStream("path/to/refreshToken.json");
        
        FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(refreshToken))
            .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
            .build();
        
        FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
    }
    
    @Bean
    public FirebaseAuth getFirebaseAuth(FirebaseApp firebaseApp) {
        return FirebaseAuth.getInstance(firebaseApp);
    }

}
```

取得回傳給前端的token
```java
class xxx {

    @Autowire
    FirebaseAuth firebaseAuth;

    public String getFirebaseCustomToken(String uid) {
        return firebaseAuth.createCustomToken(uid);
    }
}
```

web端使用token上傳
```
import firebase from 'firebase/app';

const storageRef = firebase.storage().ref();

const filebaseUpload = {};

/**
 * 後面接.then((snapshot) => {
      // 文件上传成功
    })
    .catch((error) => {
      // 处理错误
    });
 */
filebaseUpload.updateFileToFirebase = (token, path, file) => {
  const fileRef = storageRef.child(path);
  return firebase.auth().signInWithCustomToken(token)
    .then(() => {
      return fileRef.put(file);
    });
}

export default filebaseUpload;
```
