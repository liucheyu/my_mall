## openFeign

依賴項目
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

調用方要在設定檔或app進入點加註解
```java
@EnableFeignClients(basePackages = "com.liucheyu.mymall.mallmember.feign")
public class MallMemberApplication {
    //...
}
```

spring boot在Hoxton之後，負載平衡改為使用loadbalancer，設定要改

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
```

```xml
   <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
                </exclusion>
            </exclusions>
   </dependency>
```

加入調用的interface
- interface加上註解@FeignClient，()內填入要調用的服務名稱
- @RequestMapping的()內為完整的服務url的子路徑
```java

@FeignClient("mall-coupon")
public interface CouponFeignService {

    @RequestMapping("/mallcoupon/coupon/member/coupon")
    public R memberCoupons();
}

```

之後就可以用@Autowire引入並調用
```java
class Test {
 @Autowired
 private CouponFeignService couponFeignService;

//....
}
```
