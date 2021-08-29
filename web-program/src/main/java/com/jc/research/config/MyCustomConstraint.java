package com.jc.research.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: springboot-combat-faction
 * @description: 自定义验证功能
 * @author: SunChao
 * @create: 2021-08-29 18:54
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyCustomConstraintValidator.class)
public @interface MyCustomConstraint {

    /**
     * 错误提示
     * @return
     */
    String message()  default "请输入中国政治或经济中心的城市名";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
