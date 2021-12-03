package org.lushen.mrh.supports.file.matcher;

/**
 * rar压缩文件类型
 * 
 * @author helm
 */
public class CompressRarMatcher extends AbstractFileMatcher {

	public CompressRarMatcher() {
		super(new int[]{0x52, 0x61, 0x72, 0x21});
	}

}
