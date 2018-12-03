package com.angel.blogs.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:LogService<br/>
 * Description:业务层的日志管理<br/>
 * @author 	changboalong<br/>
 * @date 	2018-01-05 10:26:18<br/>
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLog {
	
	/**
	 * 方法描述
	 * @return
	 * @author changbaolong
	 * @date 2018-01-05 10:29:46
	 */
	String description() default  ""; 

}