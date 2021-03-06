package cn.segema.learn.interview.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * @description 自定义注解，用来配置方法
 * @author wangyong
 * @createDate 2020/08/30
 */
@Retention(RetentionPolicy.RUNTIME) // 表示注解在运行时依然存在
@Target(ElementType.METHOD) // 表示注解可以被使用于方法上
public @interface SayHiAnnotation {
	String paramValue() default "johness"; // 表示我的注解需要一个参数 名为"paramValue" 默认值为"johness"
}