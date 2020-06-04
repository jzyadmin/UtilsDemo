package demo.dubbospi.other;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("a1")
public interface DemoService {
    void sayHello();

    @Adaptive("tttt")
    void adaptiveUse(URL url);
}