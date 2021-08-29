package com.jc.research.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @program: springboot-combat-faction
 * @description:
 * @author: SunChao
 * @create: 2021-08-29 18:57
 **/
public class MyCustomConstraintValidator implements ConstraintValidator<MyCustomConstraint, String> {
   @Override
   public void initialize(MyCustomConstraint constraintAnnotation) {
      //在启动时执行
   }

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      return value.equals("北京") || value.equals("上海");
   }
}
