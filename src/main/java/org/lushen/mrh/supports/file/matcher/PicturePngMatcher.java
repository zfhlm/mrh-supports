package org.lushen.mrh.supports.file.matcher;

/**
 * PNG图片类型
 * 
 * @author helm
 */
public class PicturePngMatcher extends AbstractFileMatcher {

	public PicturePngMatcher() {
		super(new int[]{0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A});
	}

}
