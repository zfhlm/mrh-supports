package org.lushen.mrh.supports.runtime;

/**
 * 获取当前运行时启动类
 * 
 * @author helm
 */
public class JavaCommandLoader implements RuntimeLoader<Class<?>> {

	private static final String SUN_JAVA_COMMAND = "sun.java.command";

	private static final JavaCommandLoader instance = new JavaCommandLoader();

	/**
	 * 获取当前类型实例
	 * 
	 * @return
	 */
	public static final JavaCommandLoader instance() {
		return instance;
	}

	private JavaCommandLoader() {
		super();
	}

	@Override
	public Class<?> load() throws Exception {
		String command = System.getProperty(SUN_JAVA_COMMAND);
		if(command == null) {
			throw new RuntimeException("No value for system property " + SUN_JAVA_COMMAND);
		}
		return Class.forName(command);
	}

}
