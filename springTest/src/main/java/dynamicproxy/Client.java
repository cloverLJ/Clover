package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import javax.activation.DataSource;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;
import org.springframework.transaction.jta.TransactionFactory;

public class Client
{
	public static void main(String[] args)
	{
		RealSubject realSubject = new RealSubject();

		InvocationHandler handler = new DynamicSubject(realSubject);
		TransactionProxyFactoryBean aa;

		DataSourceTransactionManager bb;
		
		Class<?> classType = handler.getClass();

		Subject subject = (Subject) Proxy.newProxyInstance(classType
				.getClassLoader(), realSubject.getClass().getInterfaces(),
				handler);

		subject.request();

		System.out.println(subject.getClass());

	}

}
