package demo.dubbospi;

import demo.dubbospi.activate.DemoActivateService;
import demo.dubbospi.other.DemoService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/5/21 22:07
 **/
public class TestDubboSpiDemo {
    /**
     * 通过别名查找
     */
    @Test
    public void dubboSpiTest() {
        ExtensionLoader<DemoService> demo = ExtensionLoader.getExtensionLoader(DemoService.class);
        demo.getExtension("a1").sayHello();
        demo.getExtension("b2").sayHello();
    }
    /**
     * 通过@Spi标签中的默认指定查找
     */
    @Test
    public void dubboSpiDefault() {
        ExtensionLoader<DemoService> demo = ExtensionLoader.getExtensionLoader(DemoService.class);
        demo.getDefaultExtension().sayHello();
    }

    @Test
    public void dubboSpiMethodAdaptive() {
        ExtensionLoader<DemoService> demo = ExtensionLoader.getExtensionLoader(DemoService.class);
        demo.getExtension("a4").sayHello();
    }

    /**
     * @Adaptive 用法1
     * 通过实现类的@Adaptive标签中的默认指定查找
     */
    @Test
    public void dubboSpiAdaptive() {
        ExtensionLoader<DemoService> demo = ExtensionLoader.getExtensionLoader(DemoService.class);
        demo.getAdaptiveExtension().sayHello();
    }

    /**
     * @Adaptive 用法2    动态查找实现类，采用了静态代理生成class，无对应实体类可调用
     * 通过接口类中 @Adaptive 方法注解，进行查找对应service实现类的别名
     */
    @Test
    public void dubboSpiAdaptive2() {
        ExtensionLoader<DemoService> demo = ExtensionLoader.getExtensionLoader(DemoService.class);
        URL url = URL.valueOf("aaaaaaaaaaaaa?tttt=a1");
        demo.getAdaptiveExtension().adaptiveUse(url);
    }


    /**
     * @Activate 用法
     * 通过group，value进行查找满足的类
     */
    @Test
    public void dubboSpiActivate() {
        ExtensionLoader<DemoActivateService> demo = ExtensionLoader.getExtensionLoader(DemoActivateService.class);
        URL url = URL.valueOf("aaaaaaaaaaaaa?test=c");
        demo.getActivateExtension(url , "test","young").forEach(DemoActivateService::sayHello);
    }




}
