## mybatis-plus相關功能

可配製邏輯刪除
```yaml
mybatis-plus:
  mapper-locations: classpath:mapper/**/*.xml
  global-config:
    db-config: 
      logic-delete-value: 1
      logic-not-delete-value: 0
```

搭配entity標註(注意0和1哪個是刪除)
```
@TableLogic(value = "1", delval = "0")
```




