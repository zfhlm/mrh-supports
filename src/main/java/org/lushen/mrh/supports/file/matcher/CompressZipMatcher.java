package org.lushen.mrh.supports.file.matcher;

/**
 * zip压缩文件类型
 * 
 * @author helm
 */
public class CompressZipMatcher extends AbstractFileMatcher {

	public CompressZipMatcher() {
		super(new int[]{0x50, 0x4B, 0x03, 0x04});
	}

}
