package org.lushen.mrh.supports.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.commons.lang3.ClassUtils;

/**
 * jdk动态代理对象生成器
 * 
 * @author helm
 */
@SuppressWarnings("unchecked")
public class JdkProxyProvider implements ProxyProvider {

	private static final JdkProxyProvider instance = new JdkProxyProvider();

	/**
	 * 获取当前类型实例
	 * 
	 * @return
	 */
	public static final JdkProxyProvider instance() {
		return instance;
	}

	private JdkProxyProvider() {
		super();
	}

	@Override
	public <T> T create(Class<T> proxyClass, ProxyHandler proxyHandler) throws Exception {
		if(proxyClass == null) {
			throw new IllegalArgumentException("proxyClass is null.");
		}
		if(proxyHandler == null) {
			throw new IllegalArgumentException("proxyHandler is null.");
		}
		Class<?>[] interfaces = ClassUtils.getAllInterfaces(proxyClass).stream().toArray(len -> new Class<?>[len]);
		return (T) Proxy.newProxyInstance(proxyClass.getClassLoader(), interfaces, new java.lang.reflect.InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return proxyHandler.invoke(proxyClass, proxy, method, args);
			}
		});
	}

}
