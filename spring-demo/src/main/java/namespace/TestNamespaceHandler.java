package namespace;


import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class TestNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("redis", new TestBeanDefinitionParser());
	}

}