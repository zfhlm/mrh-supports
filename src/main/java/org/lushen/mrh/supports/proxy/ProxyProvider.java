package org.lushen.mrh.supports.proxy;

/**
 * 代理对象生成器
 * 
 * @author helm
 */
public interface ProxyProvider {

	/**
	 * 生成代理对象
	 * 
	 * @param proxyClass
	 * @param proxyHandler
	 * @return
	 * @throws Exception
	 */
	public <T> T create(Class<T> proxyClass, ProxyHandler proxyHandler) throws Exception;

}
