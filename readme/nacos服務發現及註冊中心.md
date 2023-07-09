## Nacos服務發現及設定中心

官方文檔[連結](https://nacos.io/zh-cn/index.html)

步驟:

1. 安裝Nacos並啟動: 
```
# linux
startup.sh -m standalone
# windows
startup.cmd -m standalone
```
2. 引入依賴: 
```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```

3.服務發現配置: 
```yaml
spring:
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
  application:
    name: mall-coupon
```

4.服務設定中心配置: 
 - 創建bootstrap.properties
```properties
spring.cloud.nacos.config.server-addr=127.0.0.1:8848
spring.application.name=mall-coupon
```

5.設定中心心新增prperties後可於code中用@Value("${}")取值
6.使用@Value("${}")的class標註@RefreshScope，可取得設定中心的動態更新
```java
@RefreshScope
@RestController
@RequestMapping("mallcoupon/coupon")
public class CouponController {
    @Value("${coupon.user.username}")
    String userName;
    @Value("${coupon.user.age}")
    String age;
}
```

8.Nacos web: 127.0.0.1:8848/nacos

9.設定中心配置: 
- namespace: 命名空間隔離
    1. 依據環境名稱: bootstrap.properties指定spring.cloud.nacos.config.namespace，填入id
    2. 依據服務名稱
- dataId: 服務的ID(ex: mall-coupon.properties、database.properties)，相當於設定檔的ID
- groupId: 分組ID

用法1:
namespace新增各個服務名稱，
各服務產生的namespaceID填入bootstrap.properties的spring.cloud.nacos.config.namespace
各服務的dataID設該服務的id，
各服務用groupId來區分環境(dev、test、prod等)，spring.cloud.nacos.config.group

dataId也可依據用途來新增，例如新增database.properties來存資料庫的設定，然後bootstrap.properties加入
```properties
spring.cloud.nacos.config.namespace=coupon

spring.cloud.nacos.config.ext-config[0].data-id=database.properties
spring.cloud.nacos.config.ext-config[0].group=dev
spring.cloud.nacos.config.ext-config[0].refresh=true
```


DEFAULT_GROUP為public
