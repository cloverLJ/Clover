package springTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
@SuppressWarnings("deprecation")
public class Test {
	public static void main(String[] args) {
		BeanFactory bf  = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		HelloWorld helloWord = (HelloWorld) bf.getBean("helloWorld");
		helloWord.sayHello();
	}
	

}
