package org.lushen.mrh.supports.runtime;

import java.util.jar.Attributes;

/**
 * SpringBoot META-INF/MANIFEST.MF 信息加载器
 * 
 * @author helm
 */
public class BootManifestLoader implements RuntimeLoader<BootManifest> {

	private static final BootManifestLoader instance = new BootManifestLoader();

	/**
	 * 获取当前类型实例
	 * 
	 * @return
	 */
	public static final BootManifestLoader instance() {
		return instance;
	}

	private BootManifestLoader() {
		super();
	}

	@Override
	public BootManifest load() throws Exception {
		Attributes attributes = JavaManifestLoader.instance().load().getMainAttributes();
		return new BootManifest(attributes);
	}

}
