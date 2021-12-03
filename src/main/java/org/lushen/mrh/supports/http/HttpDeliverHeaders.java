package org.lushen.mrh.supports.http;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

/**
 * 自定义请求响应 header
 * 
 * @author helm
 */
public class HttpDeliverHeaders {

	/**
	 * 请求头名称前缀
	 */
	public static final String REQUEST_DELIVER_HEADER_PREFIX = "Request-Deliver-";

	/**
	 * 响应头名称前缀
	 */
	public static final String RESPONSE_DELIVER_HEADER_PREFIX = "Response-Deliver-";

	/**
	 * 是否请求头
	 * 
	 * @param name
	 * @return
	 */
	public static final boolean isRequestDeliverHeader(String name) {
		return StringUtils.startsWithIgnoreCase(name, REQUEST_DELIVER_HEADER_PREFIX);
	}

	/**
	 * 是否响应头
	 * 
	 * @param name
	 * @return
	 */
	public static final boolean isResponseDeliverHeader(String name) {
		return StringUtils.startsWithIgnoreCase(name, RESPONSE_DELIVER_HEADER_PREFIX);
	}

	/**
	 * 获取所有 deliver 请求头
	 * 
	 * @param nameIterator
	 * @param doGetValue
	 * @return
	 */
	public static final Map<String, Collection<String>> getRequestDelivers(Iterator<String> nameIterator, Function<String, Collection<String>> doGetValue) {
		Map<String, Collection<String>> deliverHeaders = new HashMap<String, Collection<String>>();
		while(nameIterator.hasNext()) {
			String name = nameIterator.next();
			if(HttpDeliverHeaders.isRequestDeliverHeader(name)) {
				deliverHeaders.put(name, doGetValue.apply(name));
			}
		}
		return deliverHeaders;
	}

	/**
	 * 获取所有 deliver 响应头
	 * 
	 * @param nameIterator
	 * @param doGetValue
	 * @return
	 */
	public static final Map<String, Collection<String>> getResponseDelivers(Iterator<String> nameIterator, Function<String, Collection<String>> doGetValue) {
		Map<String, Collection<String>> deliverHeaders = new HashMap<String, Collection<String>>();
		while(nameIterator.hasNext()) {
			String name = nameIterator.next();
			if(HttpDeliverHeaders.isResponseDeliverHeader(name)) {
				deliverHeaders.put(name, doGetValue.apply(name));
			}
		}
		return deliverHeaders;
	}

}
