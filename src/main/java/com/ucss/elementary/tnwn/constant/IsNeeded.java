package com.ucss.elementary.tnwn.constant;

/**
 * Created by NXBJB164 on 2018/8/14.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 是否需要从解析excel赋值
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 * RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息
 * FIELD：域声明（包括enum实例）
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface IsNeeded
{

    /**
     * 是否需要从解析excel赋值
     * @return
     *         true:需要  false:不需要
     * @see [类、类#方法、类#成员]
     */
    boolean isNeeded() default true;
}
