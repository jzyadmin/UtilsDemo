package bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/8 8:34
 **/
@Component
@Data
public class Man extends AbstractMan{
    private String name;

    @Override
    public void init() {
        System.out.println("Man init ..................." + name);
    }

    @Override
    public void destroy() {
        System.out.println("Man destroy ..................." + name);
    }
}
