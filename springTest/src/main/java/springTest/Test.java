package springTest;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class Test {
	public static void main(String[] args) {
		ClassPathResource resource  = new ClassPathResource("beans.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		HelloWorld helloWord = factory.getBean("helloWorld", HelloWorld.class);
		helloWord.sayHello();
	}
	

}
