package org.lushen.mrh.supports.runtime;

/**
 * 运行时信息加载器
 * 
 * @author helm
 * @param <T>
 */
public interface RuntimeLoader<T> {

	/**
	 * 从当前运行环境加载信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public T load() throws Exception;

}
