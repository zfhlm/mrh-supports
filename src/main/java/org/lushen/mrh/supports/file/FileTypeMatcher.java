package org.lushen.mrh.supports.file;

import java.io.File;

/**
 * 文件类型匹配接口
 * 
 * @author helm
 */
public interface FileTypeMatcher {

	/**
	 * 是否当前类型文件
	 * 
	 * @param file
	 * @return
	 */
	public boolean matches(File file);

	/**
	 * 是否当前类型文件
	 * 
	 * @param buffer
	 * @return
	 */
	public boolean matches(byte[] buffer);

}
