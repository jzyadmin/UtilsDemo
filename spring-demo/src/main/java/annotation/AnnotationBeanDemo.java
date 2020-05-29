package annotation;/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/25 20:57
 **/

import org.springframework.core.Ordered;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/25 20:57
 **/
@AnnotationDemo
public class AnnotationBeanDemo implements Ordered {
    public void print() {
        System.out.println("自定义标签注解扫描器");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
