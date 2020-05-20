package annotation;
/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020-04-11 19:43
 **/

public @interface AnnotationDemo {
    short value() default 0;

    String name() default "default";
}
