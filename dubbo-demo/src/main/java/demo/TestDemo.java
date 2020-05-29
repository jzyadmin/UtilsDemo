package demo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/21 22:07
 **/
public class TestDemo {
    @Test
    public void test() {
        ServiceLoader<DemoService> demoServices = ServiceLoader.load(DemoService.class);
        demoServices.forEach(d -> d.sayHello());
    }

    /**
     * 通过别名查找
     */
    @Test
    public void dubboSpiTest() {
        ExtensionLoader<DemoService> demo = ExtensionLoader.getExtensionLoader(DemoService.class);
        demo.getExtension("a").sayHello();
        demo.getExtension("b").sayHello();
        demo.getExtension("c").sayHello();
        demo.getExtension("d").sayHello();
    }
    @Test
    public void dubboSpiActivate() {
        ExtensionLoader<DemoService> demo = ExtensionLoader.getExtensionLoader(DemoService.class);
        demo.getActivateExtension(URL.valueOf("test?test=222") , "222","young").forEach(DemoService::sayHello);
    }
    /**
     * 通过实现类的@Adaptive标签中的默认指定查找
     */
    @Test
    public void dubboSpiAdaptive() {
        ExtensionLoader<DemoService> demo = ExtensionLoader.getExtensionLoader(DemoService.class);
        demo.getAdaptiveExtension().sayHello();
    }

    /**
     * 通过@Spi标签中的默认指定查找
     */
    @Test
    public void dubboSpiDefault() {
        ExtensionLoader<DemoService> demo = ExtensionLoader.getExtensionLoader(DemoService.class);
        demo.getDefaultExtension().sayHello();
    }

}
