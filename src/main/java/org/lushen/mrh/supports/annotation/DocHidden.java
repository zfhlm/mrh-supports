package org.lushen.mrh.supports.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 注释注解，运行时有效
 * 
 * @author helm
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
public @interface DocHidden {

	boolean value() default true;

}
