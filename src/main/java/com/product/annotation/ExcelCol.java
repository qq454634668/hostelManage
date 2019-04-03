package com.product.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelCol {

    public String importName() default "";

    public String exportName() default "";

    //	public String regex() default "";

}
