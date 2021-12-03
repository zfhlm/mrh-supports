package org.lushen.mrh.supports.file.matcher;

import java.io.File;

import org.lushen.mrh.supports.file.FileTypeMatcher;

/**
 * 未知文件类型
 * 
 * @author helm
 */
public class UnknownFileMatcher implements FileTypeMatcher {

	@Override
	public boolean matches(File file) {
		return false;
	}

	@Override
	public boolean matches(byte[] buffer) {
		return false;
	}

}
