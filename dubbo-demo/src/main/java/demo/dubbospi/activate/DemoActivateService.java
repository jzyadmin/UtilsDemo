package demo.dubbospi.activate;

import org.apache.dubbo.common.extension.SPI;

@SPI("a")
public interface DemoActivateService {
    void sayHello();
}