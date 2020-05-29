package demo;

import org.apache.dubbo.common.extension.SPI;

@SPI("a")
public interface DemoService {
    void sayHello();
}