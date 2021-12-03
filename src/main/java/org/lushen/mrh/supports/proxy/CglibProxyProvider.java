package org.lushen.mrh.supports.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib动态代理对象生成器
 * 
 * @author helm
 */
@SuppressWarnings("unchecked")
public class CglibProxyProvider implements ProxyProvider {

	private static final CglibProxyProvider instance = new CglibProxyProvider();

	/**
	 * 获取当前类型实例
	 * 
	 * @return
	 */
	public static final CglibProxyProvider instance() {
		return instance;
	}

	private CglibProxyProvider() {
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
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(proxyClass);
		enhancer.setCallback( new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				return proxyHandler.invoke(proxyClass, obj, method, args);
			}
		});
		return (T)enhancer.create();
	}

}
