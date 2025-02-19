package com.gersimuca.cma.common.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataTransferObject {
  String name() default "";
}
