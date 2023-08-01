# 驗證

## 一般驗證

1. 引入 javax.validation
2. 於controller的方法參數註解@Valid或@Validated
3. @Validated()的value需指定分組的interface
4. 分組interface需創建，但不須任何方法，用於辨識
5. 於任意驗證註解(ex: @NotBlank)中，可指定分組
6. 一旦於controller方法指定分組，在dto或entity物件沒有指定groups，將不會被驗證

3:
```
@RequestMapping("/save")
public R save(@Validated(value = {AddGroup.class}) @RequestBody BrandEntity brand) {
...
}
```

4:
```java
public interface AddGroup {
}
```

5:
```
@NotBlank(message = "品牌名不得為空", groups = {AddGroup.class, UpdateGroup.class})
private String name;
```

## 自定義驗證
1. 創建驗證interface
2. 增加參數
3. 指定@interface關聯的驗證器
4. 定義驗證器
5. 於dto或entity中使用

1-3:
```java
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = { StatusValuesConstraintValidator.class }
)
public @interface StatusValues {
    String message() default "{com.liucheyu.common.valid.StatusValues.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int[] values() default {};
}
```

4:
```java
public class StatusValuesConstraintValidator implements ConstraintValidator<StatusValues, Integer> {

    Set<Integer> validSet = new HashSet<>(2);

    @Override
    public void initialize(StatusValues constraintAnnotation) {
        for (int value : constraintAnnotation.values()) {
            validSet.add(value);
        }
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return validSet.contains(integer);
    }
}

```

5:
```
@StatusValues(values = {0, 1})
private Integer showStatus;
```

